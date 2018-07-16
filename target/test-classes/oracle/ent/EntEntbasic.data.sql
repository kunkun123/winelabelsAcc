-- menus
INSERT INTO system_resources
(id,source_name,resource_type,is_platform,parent_id,resource_seq,uri,icon_cls,sort_index,available)
VALUES
('1000000','企业信息','MENU',true,'','','/ent','',0.0,true);

INSERT INTO system_resources
(id,source_name,resource_type,is_platform,parent_id,resource_seq,uri,icon_cls,sort_index,available)
VALUES
('1000300','ENT_ENTBASIC','MENULINK',true,'1000000','','/views/ent/ententbasic/ententbasic.jsp','',0.0,true);

-- authoritis
INSERT INTO system_authorities(id,authority_type,authority_code,authority_name,resource,sort_index)VALUES
  ('1000300','SYSTEM','GECKO_ENT_ENT_ENTBASIC_QUERY','ENT_ENTBASIC查询','1000300','1.0'),
  ('1000301','SYSTEM','GECKO_ENT_ENT_ENTBASIC_VIEW','ENT_ENTBASIC查看','1000300','2.0'),
  ('1000302','SYSTEM','GECKO_ENT_ENT_ENTBASIC_NEW','ENT_ENTBASIC新建','1000300','3.0'),
  ('1000303','SYSTEM','GECKO_ENT_ENT_ENTBASIC_EDIT','ENT_ENTBASIC编辑','1000300','4.0'),
  ('1000304','SYSTEM','GECKO_ENT_ENT_ENTBASIC_DELETE','ENT_ENTBASIC删除','1000300','5.0'),
  ('1000305','SYSTEM','GECKO_ENT_ENT_ENTBASIC_EXPORT','ENT_ENTBASIC导出','1000300','6.0'),
