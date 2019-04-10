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
package org.airsonic.player.controller;

import org.airsonic.player.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;                                                                                               
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/externalServicesSettings")
public class ExternalServicesSettingsController {

    @Autowired
    private SettingsService settingsService;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(Model model) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("chromecast", settingsService.isExternalServicesChromeCastEnabled());
        map.put("lastfm", settingsService.isExternalServicesLastfmEnabled());
        map.put("chartlyrics", settingsService.isExternalServicesChartlyricsEnabled());

        model.addAttribute("model", map);
        return "externalServicesSettings";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        handleParameters(request, redirectAttributes);
        redirectAttributes.addFlashAttribute("settings_toast", true);
        return "redirect:externalServicesSettings.view";
    }

    private String handleParameters(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        boolean chromecast = ServletRequestUtils.getBooleanParameter(request, "chromecast", false);
        boolean lastfm = ServletRequestUtils.getBooleanParameter(request, "lastfm", false);
        boolean chartlyrics = ServletRequestUtils.getBooleanParameter(request, "chartlyrics", false);

        settingsService.setExternalServicesChromeCastEnabled(chromecast);
        settingsService.setExternalServicesLastfmEnabled(lastfm);
        settingsService.setExternalServicesChartlyricsEnabled(chartlyrics);
        settingsService.save();
        return null;
    }
}
