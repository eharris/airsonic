/*
 This file is part of Airsonic.

 Airsonic is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 Airsonic is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with Airsonic.  If not, see <http://www.gnu.org/licenses/>.

 Copyright 2019 (C) Airsonic Authors
 */
package org.airsonic.player.command;

//import org.airsonic.player.controller.ExternalServicesSettingsController;

/**
 * Command used in {@link externalServicesSettingsController}.
 */
public class ExternalServicesSettingsCommand {

    private boolean chromecast;
		private boolean lastfm;
		private boolean chartlyrics;

    public boolean isChromeCastEnabled() {
        return chromecast;
    }

    public boolean setChromeCastEnabled(boolean chromecast) {
        return this.chromecast = chromecast;
    }

    public boolean isLastfmEnabled() {
        return lastfm;
    }

    public boolean setLastfmEnabled(boolean lastfm) {
        return this.lastfm = lastfm;

    }
    public boolean isChartlyricsEnabled() {
        return chartlyrics;
    }

    public boolean setChartlyricsEnabled(boolean chartlyrics) {
        return this.chartlyrics = chartlyrics;
    }


}
