package com.amadornes.scm.circuit.component;

import com.amadornes.scm.api.circuit.IComponentHost;
import com.amadornes.scm.api.circuit.component.IComponentInfo;
import com.amadornes.scm.api.circuit.component.IComponentState;
import com.amadornes.scm.api.circuit.component.IComponentType;
import com.amadornes.scm.api.circuit.component.quirk.IQuirk;
import com.amadornes.scm.api.math.CircuitDirection;
import com.amadornes.scm.api.util.CircuitSlot;
import com.amadornes.scm.api.util.IWorldUpdater;
import com.amadornes.scm.circuit.ComponentBase;
import com.amadornes.scm.circuit.SystemBase;
import net.minecraft.block.BlockRedstoneTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.state.StateContainer;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Stream;

public class ComponentLamp extends ComponentBase<ComponentLamp> implements IQuirk {

    private static final String SYNC_STATE = "state";

    private int inputs = 0;

    @Override
    public <Q extends IQuirk> Q getQuirk(Class<Q> type) {
        if (type == ComponentLamp.class) return (Q) this;
        return super.getQuirk(type);
    }

    @Override
    public IBlockState getActualState(IBlockState state) {
        return state.with(BlockRedstoneTorch.LIT, inputs > 0);
    }

    @Override
    public boolean isConnectable(CircuitSlot slot, CircuitDirection direction) {
        return slot == CircuitSlot.BOTTOM && direction != CircuitDirection.UP;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.putInt("inputs", inputs);
        return tag;
    }

    @Override
    public void deserializeNBT(NBTTagCompound tag) {
        inputs = tag.getInt("inputs");
    }

    @Override
    public void serialize(String key, PacketBuffer buf) {
        if (SYNC_STATE.equals(key)) {
            buf.writeBoolean(inputs > 0);
        }
    }

    @Override
    public void deserialize(String key, PacketBuffer buf, IWorldUpdater updater) {
        if (SYNC_STATE.equals(key)) {
            inputs = buf.readBoolean() ? 1 : 0;
            updater.scheduleRenderUpdate();
            updater.scheduleLightingUpdate();
        }
    }

    private static final class Logic extends SystemBase<ComponentLamp> {

        private Logic(IComponentHost host) {
            super(host);
        }

        @Override
        public void update(Stream<IComponentInfo<ComponentLamp>> components) {
            components.parallel().forEach(this::updateState);
        }

        private void updateState(IComponentInfo<ComponentLamp> info) {
            if (info.getUpdates().isEmpty()) return;

            ComponentLamp lamp = info.getQuirk();
            int prevInputs = lamp.inputs;
            for (CircuitDirection direction : info.getUpdates().getAllUpdates()) {
                if (direction == CircuitDirection.UP) continue; // We're not taking input from the up direction
                lamp.inputs &= ~(1 << direction.ordinal());
                if (getStrongInput(info.getPos(), CircuitSlot.BOTTOM, direction) > 0) {
                    lamp.inputs |= (1 << direction.ordinal());
                }
            }
            if (prevInputs != lamp.inputs) {
                info.markSave();
                info.markCommit();
                if ((prevInputs > 0) != (lamp.inputs > 0)) {
                    info.notifyClients(SYNC_STATE);
                }
            }
        }

    }

    public static final class Type extends ComponentBase.Type<ComponentLamp, Logic> {

        @Override
        public void fillStateContainer(StateContainer.Builder<IComponentType<ComponentLamp, ComponentLamp>, IComponentState> builder) {
            builder.add(BlockRedstoneTorch.LIT);
        }

        @Override
        public EnumSet<CircuitSlot> getSlots() {
            return EnumSet.of(CircuitSlot.BOTTOM, CircuitSlot.CENTER);
        }

        @Override
        public Set<Class<? extends IQuirk>> getQuirks() {
            return Collections.singleton(ComponentLamp.class);
        }

        @Override
        public ComponentLamp create() {
            return new ComponentLamp();
        }

        @Override
        public Logic create(IComponentHost host) {
            return new Logic(host);
        }

    }

}
