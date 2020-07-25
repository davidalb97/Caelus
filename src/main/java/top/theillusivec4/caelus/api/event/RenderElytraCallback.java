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

package top.theillusivec4.caelus.api.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import top.theillusivec4.caelus.api.RenderElytraInfo;

public interface RenderElytraCallback {

  Event<RenderElytraCallback> EVENT = EventFactory
      .createArrayBacked(RenderElytraCallback.class, (listeners) -> (playerEntity, info) -> {

        for (RenderElytraCallback listener : listeners) {
          listener.process(playerEntity, info);
        }
      });

  void process(PlayerEntity playerEntity, RenderElytraInfo info);
}
