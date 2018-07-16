package org.gecko.framework.manager.controller;


import org.apache.commons.lang3.StringUtils;
import org.gecko.common.utils.ReflectUtil;
import org.gecko.common.utils.UuidUtil;
import org.gecko.core.annotations.GeckoAuthority;
import org.gecko.core.mybatis.page.Page;
import org.gecko.framework.base.BaseController;
import org.gecko.framework.model.R;
import org.gecko.framework.manager.entity.MgSeller;
import org.gecko.framework.manager.service.MgSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * MG_SELLER控制器
 * @author Gecko Generator
 * @email admin@aisino.com
 * @date 2018-01-08 11:13:15
 *
 */
@Controller
@RequestMapping("/manager/mgseller")
public class MgSellerController extends BaseController<MgSeller> {

	@Autowired
	public MgSellerService service;

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
	@GeckoAuthority(codes = {"GECKO_MANAGER_MG_SELLER_QUERY"})
	public Page<MgSeller> list(Page<MgSeller> page) {
        MgSeller param = new MgSeller();
        if(page.getSearch()!=null){
        param.setTemp1("%" + page.getSearch() + "%");
		param.setTemp2("%" + page.getSearch() + "%");
		param.setEntid("%" + page.getSearch() + "%");
		param.setTemp4("%" + page.getSearch() + "%");
		param.setCreator("%" + page.getSearch() + "%");
		param.setTemp3("%" + page.getSearch() + "%");
		//param.setLastupdatetime("%" + page.getSearch() + "%");
		param.setSellernum("%" + page.getSearch() + "%");
		param.setNvrip("%" + page.getSearch() + "%");
		//param.setStatus("%" + page.getSearch() + "%");
        }
		page = service.likeByPage(param, page);
		return page;
	}

	/**
	 *
	 * @param @param id 唯一ID
	 * @param id 唯一ID
	 * @return R  返回类型
	 */
	@RequestMapping(value = "/get/{id}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_MANAGER_MG_SELLER_VIEW"})
	public R get(@PathVariable String id) {
		MgSeller mgseller = service.get(id);
		return R.ok().put(mgseller);
	}

    @RequestMapping("/edit")
    @ResponseBody
    @GeckoAuthority(codes = {"GECKO_MANAGER_MG_SELLER_EDIT"})
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
	@GeckoAuthority(codes = {"GECKO_MANAGER_MG_SELLER_DELETE"})
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
	@GeckoAuthority(codes = {"GECKO_MANAGER_MG_SELLER_NEW", "GECKO_MANAGER_MG_SELLER_EDIT"})
	public R save(@RequestBody MgSeller entity) {
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
	 * export  导出数据
	 * @param ids 唯一ID列表
	 * @return R返回类型
	 */
	@RequestMapping(value = "/export/{ids}", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@GeckoAuthority(codes = {"GECKO_MANAGER_MG_SELLER_EXPORT"})
	public R export(@PathVariable String[] ids) {
		return R.ok();
	}
}
