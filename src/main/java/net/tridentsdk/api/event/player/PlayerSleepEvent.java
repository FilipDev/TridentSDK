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
package net.tridentsdk.api.event.player;

import net.tridentsdk.api.Block;
import net.tridentsdk.api.entity.living.Player;
import net.tridentsdk.api.event.Ignorable;

/**
 * Called when a player tries to get in a bed
 */
public class PlayerSleepEvent extends PlayerEvent implements Ignorable {
    private final Block bed;
    private boolean cancel;

    public PlayerSleepEvent(Player player, Block bed) {
        super(player);
        this.bed = bed;
    }

    @Override
    public boolean isIgnored() {
        return cancel;
    }

    @Override
    public void ignore(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * Gets the bed that the player tried to enter
     */
    public Block getBed() {
        return this.bed;
    }
}
