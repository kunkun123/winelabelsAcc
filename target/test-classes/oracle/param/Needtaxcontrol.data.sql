-- menus
INSERT INTO system_resources
(id,source_name,resource_type,is_platform,parent_id,resource_seq,uri,icon_cls,sort_index,available)
VALUES
('200000','参数信息表','MENU',true,'','','/param','',0.0,true);

INSERT INTO system_resources
(id,source_name,resource_type,is_platform,parent_id,resource_seq,uri,icon_cls,sort_index,available)
VALUES
('200700','NEEDTAXCONTROL','MENULINK',true,'200000','','/views/param/needtaxcontrol/needtaxcontrol.html','',0.0,true);

-- authoritis
INSERT INTO system_authorities(id,authority_type,authority_code,authority_name,resource,sort_index)VALUES
  ('200700','SYSTEM','GECKO_PARAM_NEEDTAXCONTROL_QUERY','NEEDTAXCONTROL查询','200700','1.0'),
  ('200701','SYSTEM','GECKO_PARAM_NEEDTAXCONTROL_VIEW','NEEDTAXCONTROL查看','200700','2.0'),
  ('200702','SYSTEM','GECKO_PARAM_NEEDTAXCONTROL_NEW','NEEDTAXCONTROL新建','200700','3.0'),
  ('200703','SYSTEM','GECKO_PARAM_NEEDTAXCONTROL_EDIT','NEEDTAXCONTROL编辑','200700','4.0'),
  ('200704','SYSTEM','GECKO_PARAM_NEEDTAXCONTROL_DELETE','NEEDTAXCONTROL删除','200700','5.0'),
  ('200705','SYSTEM','GECKO_PARAM_NEEDTAXCONTROL_EXPORT','NEEDTAXCONTROL导出','200700','6.0'),
