/*
 * Copyright (c) 2019-2020 C4
 *
 * This file is part of Caelus, a mod made for Minecraft.
 *
 * Caelus is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Caelus is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Caelus.  If not, see <https://www.gnu.org/licenses/>.
 */

package top.theillusivec4.caelus.loader.common;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import top.theillusivec4.caelus.api.CaelusApi;

public class MixinHooks {

  public static boolean canFly(LivingEntity livingEntity, int roll, boolean flag) {
    boolean bl = flag;
    if (bl && !livingEntity.isOnGround() && !livingEntity.hasVehicle() && !livingEntity
        .hasStatusEffect(StatusEffects.LEVITATION) && CaelusApi.getInstance()
        .canFly(livingEntity)) {
      bl = true;
      ItemStack itemStack = livingEntity.getEquippedStack(EquipmentSlot.CHEST);

      if (itemStack.getItem() == Items.ELYTRA && ElytraItem.isUsable(itemStack)) {

        if (!livingEntity.world.isClient && (roll + 1) % 20 == 0) {
          itemStack.damage(1, livingEntity,
              livingEntity1 -> livingEntity1.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
        }
      }
    } else {
      bl = false;
    }
    return bl;
  }

  public static boolean startFlight(PlayerEntity playerEntity) {

    if (!playerEntity.isOnGround() && !playerEntity.isFallFlying() && !playerEntity
        .isTouchingWater() && !playerEntity.hasStatusEffect(StatusEffects.LEVITATION) && CaelusApi
        .getInstance().canFly(playerEntity)) {
      playerEntity.startFallFlying();
      return true;
    }
    return false;
  }

  public static void checkEquippedElytra(PlayerEntity playerEntity) {
    EntityAttributeInstance attributeInstance = playerEntity
        .getAttributeInstance(CaelusApi.ELYTRA_FLIGHT);

    if (attributeInstance != null) {
      attributeInstance.removeModifier(CaelusApi.VANILLA_ELYTRA_MODIFIER);
      ItemStack stack = playerEntity.getEquippedStack(EquipmentSlot.CHEST);

      if (stack.getItem() instanceof ElytraItem && !attributeInstance
          .hasModifier(CaelusApi.VANILLA_ELYTRA_MODIFIER) && ElytraItem.isUsable(stack)) {
        attributeInstance.addTemporaryModifier(CaelusApi.VANILLA_ELYTRA_MODIFIER);
      }
    }
  }
}
