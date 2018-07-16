package org.gecko.framework.ent.controller;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.gecko.common.utils.GeckoProperties;
import org.gecko.common.utils.ReflectUtil;
import org.gecko.common.utils.UuidUtil;
import org.gecko.core.annotations.GeckoAuthority;
import org.gecko.core.mybatis.page.Page;
import org.gecko.framework.base.BaseController;
import org.gecko.framework.model.R;
import org.gecko.framework.system.entity.Account;
import org.gecko.framework.system.entity.Organization;
import org.gecko.framework.system.service.AccountService;
import org.gecko.framework.system.service.OrganizationService;
import org.gecko.framework.utils.GenerateIdUtils;
import org.gecko.framework.wineLabels.entity.AlAlcoholflow;
import org.gecko.framework.wineLabels.entity.AlAlcohollable;
import org.gecko.framework.wineLabels.entity.enums.WineLablesStatus;
import org.gecko.framework.wineLabels.service.AlAlcoholflowService;
import org.gecko.framework.wineLabels.service.AlAlcohollableService;
import org.gecko.framework.ent.entity.EntApplication;
import org.gecko.framework.ent.entity.EntEntbasic;
import org.gecko.framework.ent.entity.enums.ApplicationType;
import org.gecko.framework.ent.entity.enums.AuditingStatus;
import org.gecko.framework.ent.service.EntApplicationService;
import org.gecko.framework.ent.service.EntEntbasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * 酒标申请记录控制器
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-01-05 20:31:34
 *
 */
@Controller
@RequestMapping("/ent/entapplication")
public class EntApplicationController extends BaseController<EntApplication> {

	@Autowired
	public EntApplicationService service;
	@Autowired
	AlAlcohollableService alcohollabelService;
	@Autowired
	OrganizationService orgService;
	@Autowired
	AlAlcoholflowService alcoholflowService;
	@Autowired
	AccountService accountService;
	@Autowired
	EntEntbasicService entBasicService;
	/**
	 * index
	 * 打开首页
	 * @param  model    设定文件
	 * @return String   返回类型
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		return "";
	}

	/**
	 * 数据列表
	 * @param page 分页设置
	 * @param search 查询参数
	 * @param order 排序
	 * @return R返回类型
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_ENT_ENT_APPLICATION_QUERY"})
	public Page<EntApplication> list(Page<EntApplication> page) {
        EntApplication param = new EntApplication();
        if(page.getSearch()!=null){
       // param.setAuditdate("%" + page.getSearch() + "%");
//param.setProducttype("%" + page.getSearch() + "%");
param.setTemp4("%" + page.getSearch() + "%");
//param.setAuditingstatus("%" + page.getSearch() + "%");
param.setProductnumber("%" + page.getSearch() + "%");
//param.setAduittype("%" + page.getSearch() + "%");
param.setAuditor("%" + page.getSearch() + "%");
//param.setLastupdatetime("%" + page.getSearch() + "%");
param.setTemp2("%" + page.getSearch() + "%");
param.setApplicant("%" + page.getSearch() + "%");
param.setTemp1("%" + page.getSearch() + "%");
param.setReason("%" + page.getSearch() + "%");
param.setTemp3("%" + page.getSearch() + "%");
//param.setApplicandate("%" + page.getSearch() + "%");
param.setCreator("%" + page.getSearch() + "%");
        }
		page = service.likeByPage(param, page);
		return page;
	}
	/**
	 * 申领审核的列表
	 * @param order 排序
	 * @return R返回类型
	 */
	@RequestMapping(value = "/winelabelsAuditList", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_ENT_ENT_APPLICATION_QUERY"})
	public List<EntApplication> winelabelsAuditList(Page<EntApplication> page,HttpServletRequest request) {
        EntApplication param = new EntApplication();
        if(page.getSearch()!=null){
        	param.setCreator("%" + page.getSearch() + "%");
        }
        //param.setAuditingstatus(AuditingStatus.NE);
		page = service.likeByPage(param, page);
		List<EntApplication> entApplications = page.getRows();
		if(entApplications.size()>0){
			List<EntApplication> entApplicationShows = new ArrayList<EntApplication>();
			for (Iterator iterator = entApplications.iterator(); iterator.hasNext();) {
				EntApplication entApplication = (EntApplication) iterator.next();
				EntApplication entApplicationShow = new EntApplication();
				/**根据申请人查询申请企业**/
				String accountId = entApplication.getApplicant();
				if(!org.springframework.util.StringUtils.isEmpty(accountId)){
					Account account = accountService.get(accountId);
					if(null!=account){
						String entId = account.getPrincipal();
						EntEntbasic entBasic = entBasicService.get(entId);
						if(null!=entBasic){
							entApplicationShow.setTemp3(entBasic.getCreditcode());
							//企业id
							entApplicationShow.setTemp4(entBasic.getId());
						}
						entApplicationShow.setApplicant(account.getRealName());
					}
				}
				
				entApplicationShow.setProductnumber(entApplication.getProductnumber());
				//产品种类
				entApplicationShow.setTemp1(entApplication.getProducttype().getValue());
				entApplicationShow.setApplicandate(entApplication.getApplicandate());
				entApplicationShow.setId(entApplication.getId());
				entApplicationShow.setAuditor(entApplication.getAuditingstatus().getValue());
				/**查询剩余酒标数量**/
				AlAlcohollable entApplicationNum = new AlAlcohollable();
				entApplicationNum.setApplicant(entApplication.getApplicant());
				entApplicationNum.setStatus(WineLablesStatus.UNUSERD);
				List<AlAlcohollable> entApplicationNums = alcohollabelService.find(entApplicationNum);
				entApplicationShow.setTemp2(entApplicationNums.size()+"");
				entApplicationShows.add(entApplicationShow);
			}
			return entApplicationShows;
		}else{
			return null; 
		}
	}
	
	/**
	 * 酒标审核
	 * @param order 排序
	 * @return R返回类型
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/winelabelsAudit", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_ENT_ENT_APPLICATION_QUERY"})
	public ModelAndView winelabelsAudit(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException {

		ModelAndView mad = new ModelAndView("/wineLabels/alalcohollable/labelListView");
		String reason = request.getParameter("reason");
		String status = request.getParameter("winelabelsStatus");
		String applicantId = request.getParameter("applicantId");
		if(org.springframework.util.StringUtils.isEmpty(reason)){
			status = new String(status.getBytes("iso-8859-1"),"utf-8");
		}
		EntApplication application = service.get(applicantId);
		 //获取当前登录的用户
	    Account acct = (Account) session.getAttribute(GeckoProperties.SESSION_KEY);
		/**审核通过**/
		if("ON".equals(status)){
			/**酒标申请表补充数据**/
		    application.setAuditingstatus(AuditingStatus.ON);
		    application.setAuditor(acct.getId());
		    Date dateNow = new Date();
		    java.sql.Date date = new java.sql.Date(dateNow.getTime());
		    application.setAuditdate(date);
		    application.setReason(reason);
		    application.setLastupdatetime(GenerateIdUtils.getCurrentSqlDate());
		    service.update(application);
			/**酒标表建立数据**//**酒标流转表建立数据**/
		    String numStr = application.getProductnumber();
		    int number = Integer.parseInt(numStr);
		    Organization org = orgService.getOrganizationByAccountId(acct.getId());
		    String orgName = "";
			if(org!=null){
				orgName = org.getOrgName();
			}
		    for (int i = 0; i < number; i++) {
		    	String serial = GenerateIdUtils.generateId32();
				AlAlcohollable alcohollable = new AlAlcohollable();
				alcohollable.setId(GenerateIdUtils.generateId32());
				alcohollable.setSerial(serial);
				alcohollable.setGrant(orgName);
				alcohollable.setStatus(WineLablesStatus.UNUSERD);
				alcohollable.setApplicant(application.getApplicant());
				alcohollable.setApplicanid(application.getId());
				alcohollable.setCreator(acct.getId());
				alcohollable.setOwner(application.getApplicant());
				alcohollable.setAltype(application.getProducttype());
				alcohollable.setLastupdatetime(GenerateIdUtils.getCurrentSqlDate());
				alcohollabelService.save(alcohollable);
				
				AlAlcoholflow alcoholflow2 = new AlAlcoholflow();
				alcoholflow2.setSerial(serial);
				alcoholflow2.setId(GenerateIdUtils.generateId32());
				alcoholflow2.setFlowname("酒标申请");
				alcoholflow2.setCreator(application.getApplicant());
				alcoholflow2.setLastupdatetime(GenerateIdUtils.getCurrentSqlDate());
				alcoholflowService.save(alcoholflow2);
				
				AlAlcoholflow alcoholflow1 = new AlAlcoholflow();
				alcoholflow1.setSerial(serial);
				alcoholflow1.setId(GenerateIdUtils.generateId32());
				alcoholflow1.setFlowname("酒标审核");
				alcoholflow1.setCreator(acct.getId());
				alcoholflow1.setLastupdatetime(GenerateIdUtils.getCurrentSqlDate());
				alcoholflowService.save(alcoholflow1);
			}
		}else if("UN".equals(status)){
			/**酒标申请表补充数据**/
			application.setAuditingstatus(AuditingStatus.UN);
		    application.setAuditor(acct.getId());
		    Date dateNow = new Date();
		    java.sql.Date date = new java.sql.Date(dateNow.getTime());
		    application.setAuditdate(date);
		    application.setReason(reason);
		    application.setLastupdatetime(GenerateIdUtils.getCurrentSqlDate());
		    service.update(application);
		}
		return mad;
	}
	/**
	 *
	 * @param @param id 唯一ID
	 * @param id 唯一ID
	 * @return R  返回类型
	 */
	@RequestMapping(value = "/get/{id}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_ENT_ENT_APPLICATION_VIEW"})
	public R get(@PathVariable String id) {
		EntApplication entapplication = service.get(id);
		return R.ok().put(entapplication);
	}

    @RequestMapping("/edit")
    @ResponseBody
    @GeckoAuthority(codes = {"GECKO_ENT_ENT_APPLICATION_EDIT"})
    public R updateField(@RequestParam("name") String name, @RequestParam("value") String value, @RequestParam("pk") String pk) {
        R r = R.error();
        if (service.updateField(name, value, pk) > 0) {
            r = R.ok();
        }
        return r;
    }

	/**
	 * 根据ID列表批量删除对象
	 * @param ids 唯一ID列表
	 * @return R 返回类型
	 */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_ENT_ENT_APPLICATION_DELETE"})
	public R delete(@RequestBody String[] ids) {
		service.batchDelete(ids);
		return R.ok();
	}

	/**
     * save 保存对象
     * @param entity
     * @return R返回类型
     */
	@RequestMapping(value = "/save", method = RequestMethod.PUT)
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_ENT_ENT_APPLICATION_NEW", "GECKO_ENT_ENT_APPLICATION_EDIT"})
	public R save(@RequestBody EntApplication entity) {
        R r = new R();
		if(null != entity.getId() && StringUtils.isNoneBlank(String.valueOf(entity.getId()))) {
			service.update(entity);
            r = R.ok();
		} else {
            if (org.springframework.util.StringUtils.isEmpty(entity.getId())) {
                entity.setId(UuidUtil.get32UUID());
                ReflectUtil.fillsProperty(entity);
            }
			r.put(service.save(entity));
		}
		return r;
	}
	/**
	 *	酒标申领历史查看
	 */
	@RequestMapping(value = "/applicationHis")
	@ResponseBody
	public List<EntApplication> applicationHis(HttpServletRequest request) {
		
		List<EntApplication> entApplications = null;
		String entId = request.getParameter("entId");
		//根据企业id获取账号id
		Account account = new Account();
		account.setPrincipal(entId);
		List<Account> accounts = accountService.find(account);
		if(accounts.size()>0){
			Account acc = accounts.get(0);
			EntApplication application = new EntApplication();
			application.setAduittype(ApplicationType.WINELABELS);
			application.setApplicant(acc.getId());
			entApplications = service.find(application);
			for (Iterator iterator = entApplications.iterator(); iterator.hasNext();) {
				EntApplication entApplication = (EntApplication) iterator.next();
				if(entApplication.getAuditingstatus().getKey()==1){
					entApplication.setTemp1("未通过");
				}else if(entApplication.getAuditingstatus().getKey()==2){
					entApplication.setTemp1("已通过");
				}else if(entApplication.getAuditingstatus().getKey()==3){
					entApplication.setTemp1("待审核");
				}
				if(entApplication.getProducttype().getKey()==1){
					entApplication.setTemp2("白酒");
				}else if(entApplication.getProducttype().getKey()==2){
					entApplication.setTemp2("啤酒");
				}else if(entApplication.getProducttype().getKey()==3){
					entApplication.setTemp2("黄酒");
				}else if(entApplication.getProducttype().getKey()==3){
					entApplication.setTemp2("其他酒");
				}
			}
		}
		return entApplications;
	}
	/**
	 * export  导出数据
	 * @param ids 唯一ID列表
	 * @return R返回类型
	 */
	@RequestMapping(value = "/export/{ids}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_ENT_ENT_APPLICATION_EXPORT"})
	public R export(@PathVariable String[] ids) {
		return R.ok();
	}
}
