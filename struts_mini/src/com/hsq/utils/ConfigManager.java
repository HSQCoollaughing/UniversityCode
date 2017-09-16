package com.hsq.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.hsq.bean.ActionConfig;
import com.hsq.bean.ResultTag;

public class ConfigManager {
	//private static Map<String,ActionConfig> acmap;

	public static Map<String,ActionConfig> getActionConfig(){
		Map<String,ActionConfig> acmap=  new HashMap<String,ActionConfig>();;
		//����������
		//����xmlwenjian  =>����document����
		//����xpath���ʽ =���ҵ�actionԪ��
		//����actionԪ��
		//���з�װ
		SAXReader reader = new SAXReader();
		InputStream inputstream = ConfigManager.class.getResourceAsStream("/struts.xml");
		try {
			Document document = reader.read(inputstream);
			String xpath="//action";
			List<Element> actionsTag = document.selectNodes(xpath);
			for (Element action : actionsTag) {
				ActionConfig actiontag = new ActionConfig();
				actiontag.setClazz(action.attributeValue("class"));
				actiontag.setMethod(action.attributeValue("method"));
				actiontag.setName(action.attributeValue("name"));
				//��Ԫ��
				System.out.println(actiontag);
				Map<String,ResultTag> resultTags=new HashMap<String,ResultTag>();
				
				 List<Element> resulttag = action.elements("result");
				 for (Element e:resulttag) {
					ResultTag rt = new ResultTag();
					rt.setName(e.attributeValue("name"));
					rt.setTargetjsp(e.getText());
					resultTags.put(rt.getName(), rt);
					System.out.println(rt);
				}
				 actiontag.setResulttag(resultTags);
				
				 acmap.put(actiontag.getName(), actiontag);
			}
			return acmap;
			
		} catch (DocumentException e) {
			throw new RuntimeException("�����ļ�����ʧ��");
		}
		
	}

}
