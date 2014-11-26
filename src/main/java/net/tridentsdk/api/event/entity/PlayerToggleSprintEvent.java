/*
 *     TridentSDK - A Minecraft Server API
 *     Copyright (C) 2014, The TridentSDK Team
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.tridentsdk.api.event.entity;

import net.tridentsdk.api.entity.living.Player;
import net.tridentsdk.api.event.Ignorable;
import net.tridentsdk.api.event.player.PlayerEvent;

/**
 * Called when a player tries to start sprinting, even if hunger would otherwise prevent them from sprinting
 */
public class PlayerToggleSprintEvent extends PlayerEvent implements Ignorable {
    private final boolean toggle;
    private boolean cancel;

    public PlayerToggleSprintEvent(Player player, boolean toggle) {
        super(player);
        this.toggle = toggle;
    }

    /**
     * @return true if the player is trying to sprint
     */
    public boolean sprintOn() {
        return this.toggle;
    }

    /**
     * @return true if the player is trying to stop sprinting
     */
    public boolean sprintOff() {
        return !this.toggle;
    }

    @Override
    public boolean isIgnored() {
        return cancel;
    }

    @Override
    public void ignore(boolean cancel) {
        this.cancel = cancel;
    }
}
