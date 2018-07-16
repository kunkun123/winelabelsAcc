package org.gecko.framework.system.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.gecko.framework.ent.entity.EntEntbasic;
import org.gecko.framework.ent.entity.enums.AuditingStatus;
import org.gecko.framework.ent.service.EntEntbasicService;
import org.gecko.framework.file.FileUpload;
import org.gecko.framework.utils.GenerateIdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 * 企业注册控制器
 * @author Aisino.liuyk
 * @email liuyikun@aisino.com
 * @date 2018年1月5日
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	public EntEntbasicService entBasicService;
	/**
	 * 跳转到企业注册的页面
	 * @return
	 */
	@RequestMapping("/registerView")
	public ModelAndView registerView(){
		ModelAndView mad = new ModelAndView("/views/system/login.jsp");
		mad.addObject("registerIframeSrc","/views/register/register1.jsp");
		return mad;
	}
	/**
	 * 企业注册表单提交1
	 * @return
	 */
	@RequestMapping("/registerSubmit1")
	public ModelAndView registerSubmit1(EntEntbasic entBasic,HttpSession session){
		String creditcode = entBasic.getCreditcode();
		ModelAndView mad = new ModelAndView("/views/system/register/register2.jsp");
		/**统一社会信用代码后台校验**/
		
		session.setAttribute("ENT_ENTBASIC", entBasic);
		return mad;
	}
	/**
	 * 上传营业执照
	 * @return
	 */
	@RequestMapping("/uploadInfo")
	public ModelAndView uploadInfo(@RequestParam("uploadFile") MultipartFile uploadFile,HttpServletRequest request,
			EntEntbasic entBasic,HttpSession session){
		EntEntbasic entBasicEdit = (EntEntbasic) session.getAttribute("ENT_ENTBASIC");
		ModelAndView mad = new ModelAndView("/views/system/register/register2.jsp");
		/**调用相关方法识别图像并给实体赋值**/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String newFile = sdf.format(new Date());
		String savePath = newFile.concat("/upload/images");
		FileUpload fileUpload = new FileUpload();
		String url = "";
		try {
			url = fileUpload.FileUpload(uploadFile, request, savePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**实体set营业执照的附件地址**/
		entBasicEdit.setLicenseattach(savePath+"/"+url);
		session.setAttribute("ENT_ENTBASIC", entBasicEdit);
		mad.addObject("imgUrl",savePath+"/"+url);
		mad.addObject("creditCode", "520385600060508");
		mad.addObject("entName", "贵州省仁怀市茅台镇老邻居酒厂");
		mad.addObject("tel", "88693423");
		mad.addObject("account", "9558800200136624752");
		mad.addObject("address", "茅台镇");
		mad.addObject("bank", "中国工商银行");
		return mad;
	}
	/**
	 * 企业注册表单提交2
	 * @return
	 */
	@RequestMapping("/registerSubmit2")
	public ModelAndView registerSubmit2(@RequestParam("uploadFileProduce") MultipartFile uploadFileProduce,
			@RequestParam("uploadFileBusiness") MultipartFile uploadFileBusiness,@RequestParam("uploadFileSell") MultipartFile uploadFileSell,
			@RequestParam("uploadFileImport") MultipartFile uploadFileImport,HttpServletRequest request,EntEntbasic entBasic,
			HttpSession session){
		EntEntbasic entBasicEdit = (EntEntbasic) session.getAttribute("ENT_ENTBASIC");
		ModelAndView mad = new ModelAndView("/views/system/register/register4.jsp");
		/**许可证上传**/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String newFile = sdf.format(new Date());
		String savePath = newFile.concat("/upload/images");
		FileUpload fileUpload = new FileUpload();
		String producePermissionUrl = "";
		String businessPermissionUrl = "";
		String importPermissionUrl = "";
		String sellPermissionUrl = "";
		try {
			producePermissionUrl = fileUpload.FileUpload(uploadFileProduce, request, savePath);
			businessPermissionUrl= fileUpload.FileUpload(uploadFileBusiness, request, savePath);
			importPermissionUrl = fileUpload.FileUpload(uploadFileImport, request, savePath);
			sellPermissionUrl = fileUpload.FileUpload(uploadFileSell, request, savePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**添加许可证件的地址**/
		entBasicEdit.setProducepermissionurl(savePath+"/"+producePermissionUrl);
		entBasicEdit.setBusinesspermissionurl(savePath+"/"+businessPermissionUrl);
		entBasicEdit.setImportpermissionurl(savePath+"/"+importPermissionUrl);
		entBasicEdit.setSellpermissionurl(savePath+"/"+sellPermissionUrl);
		session.setAttribute("ENT_ENTBASIC", entBasicEdit);
		return mad;
	}
	
	/**
	 * 企业注册表单提交审核
	 * @return
	 */
	@RequestMapping("/registerSubmit")
	public ModelAndView registerSubmit(HttpServletRequest request,EntEntbasic entBasic,HttpSession session){
		EntEntbasic entBasicEdit = (EntEntbasic) session.getAttribute("ENT_ENTBASIC");
		ModelAndView mad = new ModelAndView("/views/system/register/success.jsp");
		/**校验实体**/
		entBasicEdit.setContacts(entBasic.getContacts());
		entBasicEdit.setEmail(entBasic.getEmail());
		entBasicEdit.setContactphone(entBasic.getContactphone());
		/**更新状态为待审核**/
		entBasicEdit.setStatus(AuditingStatus.NE);
		/**保存实体**/
		entBasicEdit.setId(GenerateIdUtils.generateId32());
		entBasicService.save(entBasicEdit);
		//mad.addObject("ENT_ENTBASIC"/**ENT_ENTBASIC**/);
		return mad;
	}
}
