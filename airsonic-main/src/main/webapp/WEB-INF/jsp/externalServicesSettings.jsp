<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <%@ include file="head.jsp" %>
    <%@ include file="jquery.jsp" %>
</head>

<body class="mainframe bgcolor1">

<c:import url="settingsHeader.jsp">
    <c:param name="cat" value="externalServicesSettings"/>
    <c:param name="toast" value="${settings_toast}"/>
</c:import>

<form method="post" action="externalServicesSettings">
    <sec:csrfInput />
		<div>
			<input type="checkbox" name="chromecast" ${chromecast? "checked": ""}/>
			<label for="chromeCastEnabled">Enable <a href="https://en.wikipedia.org/wiki/Chromecast">ChromeCast</a> integration</label>
		</div>

    <p class="detail" style="width:60%;white-space:normal">
		This is used to cast music to compatible devices.
    </p>

		<div>
			<input type="checkbox" name="lastfm" ${lastfm? "checked": ""}/>
			<label for="LastfmEnabled">Enable <a href="https://www.last.fm/">LastFM</a> integration</label>
		</div>

    <p class="detail" style="width:60%;white-space:normal">
		This is used to get details about artists and to suggest covers when missing.
    </p>
		<div>
			<input type="checkbox" name="chartlyrics" ${chartlyrics? "checked": ""}/>
			<label for="chartlyricsEnabled">Enable <a href="http://www.chartlyrics.com/">chartlyrics</a> integration</label>
		</div>

    <p class="detail" style="width:60%;white-space:normal">
		This is used to find lyrics.
    </p>

    <p>
        <input type="submit" value="<fmt:message key="common.save"/>" style="margin-right:0.3em">
        <a href='nowPlaying.view'><input type="button" value="<fmt:message key="common.cancel"/>"></a>
    </p>
</form>
</body>
</html>
