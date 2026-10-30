package dev.xcolorful.revertsulfurecubedispenser.mixin;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.cubemob.SulfurCube;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * 回滚 MC-307929（26.2 Snapshot 7 修复）：让发射器重新能给硫方怪穿戴盔甲
 * 26.2 起硫方怪的 {@code canDispenserEquipIntoSlot} 只允许 BODY 槽，修复前任意槽位都为 true
 */
@Mixin(SulfurCube.class)
public abstract class SulfurCubeMixin {

    @Inject(method = "canDispenserEquipIntoSlot", at = @At("HEAD"), cancellable = true)
    private void revertsulfurecubedispenser$allowArmorSlots(EquipmentSlot slot, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}
