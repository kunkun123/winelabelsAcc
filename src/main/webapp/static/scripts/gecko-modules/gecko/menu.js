function clickMenu(menu) {
    var frame = document.getElementById("menu-text");
    // 任务中心
    if (menu == 'task-monitor') {
        frame.src = "views/task/task-monitor/index.html";
    }
    if (menu == 'task-mine') {
        frame.src = "views/task/task-mine/index.html";
    }
    if (menu == 'task-history') {
        frame.src = "views/task/task-history/index.html";
    }
    if (menu == 'task-report') {
        frame.src = "views/task/task-report/index.html";
    }

    // 商事登记
    if (menu == 'common-net') {
        frame.src = "views/business-mgr/common-net/index.html";
    }
    if (menu == 'integration-srv') {
        frame.src = "views/business-mgr/integration-srv/index.html";
    }
    //非标受理
    if (menu == 'common-improper') {
        frame.src = "views/business-mgr/common-net/index.html";
    }
    // 系统管理
    if (menu == 'org') {
        frame.src = "views/mgr/views/system/organization/org.html";
    }
    if (menu == 'account') {
        frame.src = "views/mgr/views/system/account/account.html";
    }
    if (menu == 'role') {
        frame.src = "views/mgr/views/system/role/role.html";
    }
    if (menu == 'source') {
        frame.src = "mgr/views/system/resource/resource.html";
    }
    if (menu == 'platform') {
        frame.src = "mgr/views/system/platform/index.html";
    }
    if (menu == 'log') {
        frame.src = "mgr/views/system/logquery/index.html";
    }
    if (menu == 'authority') {
        frame.src = "views/mgr/views/system/authority/authority.html";
    }

    if (menu == 'grid-query') {
        frame.src = "mgr/views/acceptance/gridquery/index.html";
    }

    if (menu == 'grid-complex') {
        frame.src = "mgr/views/acceptance/gridcomplex/index.html";
    }
    /*数据源监控*/
    if (menu == 'dataorgin') {
        frame.src = "mgr/views/system/dataorigin/index.html";
    }
    /*sql监控*/
    if (menu == 'sqlControl') {
        frame.src = "mgr/views/system/sqlcontrol/index.html";
    }
    /*sql防火墙*/
    if (menu == 'sqlfirewall') {
        frame.src = "mgr/views/system/sqlfirewall/index.html";
    }
    /*web应用*/
    if (menu == 'webuse') {
        frame.src = "mgr/views/system/webuse/index.html";
    }
    /*url监控*/
    if (menu == 'urlControl') {
        frame.src = "mgr/views/system/urlcontrol/index.html";
    }
    /*session监控*/
    if (menu == 'sessionControl') {
        frame.src = "mgr/views/system/sessioncontrol/index.html";
    }
    /*容器监控*/
    if (menu == 'containercontrol') {
        frame.src = "mgr/views/system/containercontrol/index.html";
    }
    /*个人信息*/
    if (menu == 'pre-detail') {
        frame.src = "/system/account/personalInfo";
    }
    
     /**公告管理**/
    if (menu == 'noticeList') {
        frame.src = "/notice/mgnotice/noticeListView";
    }
     /**新增公告**/
    if (menu == 'noticeAdd') {
        frame.src = "/notice/mgnotice/noticeAdd";
    }
    /**企业列表**/
    if (menu == 'entList') {
        frame.src = "/ent/ententbasic/entListView";
    }
    /**企业待审核列表**/
    if (menu == 'entAuditList') {
        frame.src = "/ent/ententbasic/entAuditListView";
    }
    /**酒标管理**/
    if (menu == 'wineLableAudit') {
        frame.src = "/wineLabels/alalcohollable/labelListView";
    }
    /**酒标管理**/
    if (menu == 'wineLableManager') {
        frame.src = "/wineLabels/alalcohollable/wineLableManagerView";
    }
    /**应税核销**/
    if (menu == 'taxCancel') {
        frame.src = "/tax/alcirculation/taxCancelView";
    }
    /**酒标库存监**/
    if (menu == 'repertory') {
        frame.src = "/param/inventorycontrol/listView";
    }
    /**应税核销**/
    if (menu == 'needTax') {
        frame.src = "/param/needtaxcontrol/listView"
    }
    /**完税**/
    if (menu == 'endTax') {
        frame.src = "/param/finishtaxcontrol/listView";
    }
    /**超期**/
    if (menu == 'exceed') {
        frame.src = "/param/exceedcontrol/listView";
    }
    /**异常酒标**/
    if (menu == 'labelException') {
        frame.src = "/exception/alexception/labelExceptionListView";
    }
    /**参数设置**/
    if (menu == 'paramSetting') {
        frame.src = "/param/exceedparam/paramSettingView";
    }
}

function clickMenuUrl(url) {
    var frame = document.getElementById("menu-text").src = url;
    /*
    // 任务中心
    frame.src = "views/task/task-monitor/index.html";
    frame.src = "views/task/task-mine/index.html";
    frame.src = "views/task/task-history/index.html";
    frame.src = "views/task/task-report/index.html";
    // 商事登记
    frame.src = "views/business-mgr/common-net/index.html";
    frame.src = "views/business-mgr/integration-srv/index.html";
    //非标受理
    frame.src = "views/business-mgr/common-net/index.html";
    // 系统管理
    frame.src = "views/system/organization/index.html";
    frame.src = "views/system/account/index.html";
    frame.src = "views/system/role/index.html";
    frame.src = "views/system/resource/resource.html";
    frame.src = "views/system/platform/index.html";
    frame.src = "views/system/logquery/index.html";
    frame.src = "views/system/authority/index.html";
    frame.src = "views/acceptance/gridquery/index.html";
    frame.src = "views/acceptance/gridcomplex/index.html";
    */
    /*数据源监控*/
    // frame.src = "views/system/dataorigin/index.html";
    /*sql监控*/
    // frame.src = "views/system/sqlcontrol/index.html";
    /*sql防火墙*/
    // frame.src = "views/system/sqlfirewall/index.html";
    /*web应用*/
    // frame.src = "views/system/webuse/index.html";
    /*url监控*/
    // frame.src = "views/system/urlcontrol/index.html";
    /*session监控*/
    // frame.src = "views/system/sessioncontrol/index.html";
    /*容器监控*/
    // frame.src = "views/system/containercontrol/index.html";
    /*个人信息*/
    // frame.src = "views/system/perdetails/index.html";
}

var submenu = document.getElementById('submenu');
submenu.onclick = function (ev) {
    $('#submenu').find('li.active').removeClass();
    var ev = ev || window.event;
    var target = ev.target || ev.srcElement;
    var Node = target.parentElement;

    if (Node.tagName == "LI" && target.href != undefined && target.href.indexOf('#') < 0) {
        Node.className += ' ' + 'active';
    }
}
