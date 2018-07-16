-- menus
INSERT INTO system_resources
(id,source_name,resource_type,is_platform,parent_id,resource_seq,uri,icon_cls,sort_index,available)
VALUES
('200000','参数信息表','MENU',true,'','','/param','',0.0,true);

INSERT INTO system_resources
(id,source_name,resource_type,is_platform,parent_id,resource_seq,uri,icon_cls,sort_index,available)
VALUES
('200100','EXCEEDPARAM','MENULINK',true,'200000','','/views/param/exceedparam/exceedparam.html','',0.0,true);

-- authoritis
INSERT INTO system_authorities(id,authority_type,authority_code,authority_name,resource,sort_index)VALUES
  ('200100','SYSTEM','GECKO_PARAM_EXCEEDPARAM_QUERY','EXCEEDPARAM查询','200100','1.0'),
  ('200101','SYSTEM','GECKO_PARAM_EXCEEDPARAM_VIEW','EXCEEDPARAM查看','200100','2.0'),
  ('200102','SYSTEM','GECKO_PARAM_EXCEEDPARAM_NEW','EXCEEDPARAM新建','200100','3.0'),
  ('200103','SYSTEM','GECKO_PARAM_EXCEEDPARAM_EDIT','EXCEEDPARAM编辑','200100','4.0'),
  ('200104','SYSTEM','GECKO_PARAM_EXCEEDPARAM_DELETE','EXCEEDPARAM删除','200100','5.0'),
  ('200105','SYSTEM','GECKO_PARAM_EXCEEDPARAM_EXPORT','EXCEEDPARAM导出','200100','6.0'),
