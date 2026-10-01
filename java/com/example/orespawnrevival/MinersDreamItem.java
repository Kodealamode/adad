package com.example.orespawnrevival;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

/**
 * One-use item: right-click to clear a tunnel in front of you, leaving ores behind.
 * Change the three numbers below to resize the tunnel.
 */
public class MinersDreamItem extends Item {
    public static final int LENGTH = 64;
    public static final int WIDTH = 11;
    public static final int HEIGHT = 7;

    public MinersDreamItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            clearTunnel(level, player);
            level.playSound(null, player.blockPosition(), SoundEvents.GENERIC_EXPLODE,
                    SoundSource.PLAYERS, 1.0F, 1.0F);
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    private void clearTunnel(Level level, Player player) {
        Direction forward = player.getDirection();
        Direction side = forward.getClockWise();
        BlockPos origin = player.blockPosition();
        int half = WIDTH / 2;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int f = 1; f <= LENGTH; f++) {
            for (int s = -half; s <= half; s++) {
                for (int h = 0; h < HEIGHT; h++) {
                    pos.set(
                            origin.getX() + forward.getStepX() * f + side.getStepX() * s,
                            origin.getY() + h,
                            origin.getZ() + forward.getStepZ() * f + side.getStepZ() * s);

                    if (level.isOutsideBuildHeight(pos) || !level.hasChunkAt(pos)) {
                        continue;
                    }
                    if (!level.mayInteract(player, pos)) {
                        continue;
                    }

                    BlockState state = level.getBlockState(pos);
                    if (state.isAir()
                            || state.is(Tags.Blocks.ORES)
                            || state.getDestroySpeed(level, pos) < 0
                            || state.hasBlockEntity()
                            || !state.getFluidState().isEmpty()) {
                        continue;
                    }
                    level.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_CLIENTS);
                }
            }
        }
    }
}
