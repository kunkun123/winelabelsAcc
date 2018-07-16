package org.gecko.framework.tax.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.spi.LoggerFactory;
import org.gecko.common.utils.GeckoProperties;
import org.gecko.common.utils.ReflectUtil;
import org.gecko.common.utils.UuidUtil;
import org.gecko.core.annotations.GeckoAuthority;
import org.gecko.core.mybatis.page.Page;
import org.gecko.framework.base.BaseController;
import org.gecko.framework.ent.entity.enums.EntType;
import org.gecko.framework.ent.entity.enums.ProductType;
import org.gecko.framework.model.R;
import org.gecko.framework.system.entity.Account;
import org.gecko.framework.system.service.AccountService;
import org.gecko.framework.utils.GenerateIdUtils;
import org.gecko.framework.wineLabels.entity.AlProduct;
import org.gecko.framework.wineLabels.service.AlProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import oracle.sql.DATE;


/**
 * 商品表控制器
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-01-08 11:25:28
 *
 */
@Controller
@RequestMapping("/tax/alproduct")
public class TagAlProductController extends BaseController<AlProduct> {
	@Autowired
	public AlProductService service;
	@Autowired
	public AccountService accountService;
	/**
	 * 生产采集的页面跳转
	 * @return
	 */
	@RequestMapping(value = "/productionCollectionView", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView productionCollectionView() {
		ModelAndView mad = new ModelAndView("/views/tax/productionCollection.jsp");
		return mad;
	}
	/**
     * save 保存对象
     * @param entity
     * @return R返回类型
     */
	@RequestMapping(value = "/addTask", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView save(AlProduct entity,HttpSession session) {
		ModelAndView mad = new ModelAndView("/tax/alproduct/productionCollectionView");
		if(null != entity.getId() && StringUtils.isNoneBlank(String.valueOf(entity.getId()))) {
			service.update(entity);
		} else {
            if (org.springframework.util.StringUtils.isEmpty(entity.getId())) {
                entity.setId(GenerateIdUtils.generateId32());
                /**
                 * 创建者和创建日期
                 */
                Account acct = (Account) session.getAttribute(GeckoProperties.SESSION_KEY);
                entity.setCreator(acct.getId());
                Date now = new Date(); 
                entity.setCreatedate(new java.sql.Date(now.getTime()));
            }
		}
		return mad;
	}
	/**
     * save 保存对象
     * @param entity
     * @return R返回类型
     */
	@RequestMapping(value = "/editTask", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView edit(AlProduct entity,HttpSession session) {
		ModelAndView mad = save(entity,session);
		return mad;
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
	@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_PRODUCT_QUERY"})
	public List<AlProduct> list(Page<AlProduct> page) {
        AlProduct param = new AlProduct();
        page = service.likeByPage(param, page);
		List<AlProduct> alProductList = page.getRows();
		for (Iterator iterator = alProductList.iterator(); iterator.hasNext();) {
			AlProduct alProduct = (AlProduct) iterator.next();
			String accountId = alProduct.getCreator();
			if(!org.springframework.util.StringUtils.isEmpty(accountId)){
				Account account = accountService.get(accountId);
				alProduct.setCreator(account.getRealName());
			}
			ProductType productType = alProduct.getProducttype();
			if(null!=productType){
				//商品种类
				alProduct.setTemp1(productType.getValue());
			}
		}
		return page.getRows();
	}
	/**
	 * 根据ID列表批量删除对象
	 * @param ids 唯一ID列表
	 * @return R 返回类型
	 */
    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE,RequestMethod.GET})
	@ResponseBody
	//@GeckoAuthority(codes = {"GECKO_WINELABELS_AL_PRODUCT_DELETE"})
	public ModelAndView delete(@RequestParam("ids")String[] ids) {
    	ModelAndView mad = new ModelAndView("/tax/alproduct/productionCollectionView");
		service.batchDelete(ids);
		return mad;
	}
}
