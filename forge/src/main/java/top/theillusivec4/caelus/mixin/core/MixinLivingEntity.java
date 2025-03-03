/*
 * Copyright (C) 2019-2021 C4
 *
 * This file is part of Caelus.
 *
 * Caelus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Caelus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * and the GNU Lesser General Public License along with Caelus.
 * If not, see <https://www.gnu.org/licenses/>.
 *
 */

package top.theillusivec4.caelus.mixin.core;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import top.theillusivec4.caelus.mixin.util.MixinHooks;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {

  @SuppressWarnings("ConstantConditions")
  @ModifyArg(at = @At(value = "INVOKE", target = "net/minecraft/world/entity/LivingEntity.setSharedFlag(IZ)V"), method = "updateFallFlying")
  private boolean caelus$setFlag(boolean value) {
    return MixinHooks.canFly((LivingEntity) (Object) this, value);
  }
}
