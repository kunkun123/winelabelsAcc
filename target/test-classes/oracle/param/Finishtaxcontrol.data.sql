-- menus
INSERT INTO system_resources
(id,source_name,resource_type,is_platform,parent_id,resource_seq,uri,icon_cls,sort_index,available)
VALUES
('200000','参数信息表','MENU',true,'','','/param','',0.0,true);

INSERT INTO system_resources
(id,source_name,resource_type,is_platform,parent_id,resource_seq,uri,icon_cls,sort_index,available)
VALUES
('200500','FINISHTAXCONTROL','MENULINK',true,'200000','','/views/param/finishtaxcontrol/finishtaxcontrol.html','',0.0,true);

-- authoritis
INSERT INTO system_authorities(id,authority_type,authority_code,authority_name,resource,sort_index)VALUES
  ('200500','SYSTEM','GECKO_PARAM_FINISHTAXCONTROL_QUERY','FINISHTAXCONTROL查询','200500','1.0'),
  ('200501','SYSTEM','GECKO_PARAM_FINISHTAXCONTROL_VIEW','FINISHTAXCONTROL查看','200500','2.0'),
  ('200502','SYSTEM','GECKO_PARAM_FINISHTAXCONTROL_NEW','FINISHTAXCONTROL新建','200500','3.0'),
  ('200503','SYSTEM','GECKO_PARAM_FINISHTAXCONTROL_EDIT','FINISHTAXCONTROL编辑','200500','4.0'),
  ('200504','SYSTEM','GECKO_PARAM_FINISHTAXCONTROL_DELETE','FINISHTAXCONTROL删除','200500','5.0'),
  ('200505','SYSTEM','GECKO_PARAM_FINISHTAXCONTROL_EXPORT','FINISHTAXCONTROL导出','200500','6.0'),
