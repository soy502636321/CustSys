package soy.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 配置文件，用户替代旧系统中写在java文件中的选择
 * @author XiaoLiang·Hu
 *
 */
public class ConfigUtil {
	private static final Logger log = LoggerFactory.getLogger(ConfigUtil.class);
	
	public static final String KEY_GENDERS = "0001";
	public static final String KEY_YESORNO = "0002";
	
	private static ConfigUtil configUtil = new ConfigUtil();
	private static Map<String, List<OptionVO>> map;
	private ConfigUtil() {
		map = getMap();
	}
	
	public List<OptionVO> findById(String id) {
		if (map == null) {
			map = getMap();
		}
		List<OptionVO> optionVOs = map.get(id);
		return optionVOs;
	}
	
	public String findValue(String id, String key) {
		String value = null;
		if (!StringUtil.isNull(id) && !StringUtil.isNull(key)) {
			List<OptionVO> optionVOs = findById(id);
			if (!SystemUtil.isNull(optionVOs)) {
				for (OptionVO optionVO : optionVOs) {
					if (key.equals(optionVO.getKey())) {
						value = optionVO.getValue();
					}
				}
			}
		}
		return value;
	}
	
	/**
	 * 返回ConfigUtil对象，单例
	 * @return
	 */
	public static ConfigUtil getConfigUtil() {
		if (configUtil == null) {
			log.debug("新建一个ConfigUtil对象");
			configUtil = new ConfigUtil();
		}
		return configUtil;
	}
	
	private Map<String, List<OptionVO>> getMap() {
		log.debug("开始解析配置文件config.xml");
		try {
			this.map = new HashMap<String, List<OptionVO>>();
			URL url = Thread.currentThread().getContextClassLoader().getResource("config.xml");
			//获得配置文件
			File file = new File(url.getFile());
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			//开始解析配置文件
			Element element = document.getDocumentElement();
			NodeList nodeList = element.getElementsByTagName("option");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element node = (Element) nodeList.item(i);
				String id = node.getAttribute("id");
				List<OptionVO> optionVOs = new ArrayList<OptionVO>();
				NodeList list = node.getChildNodes();
				for (int j = 0; j < list.getLength(); j++) {
					Node childNode = list.item(j);
					if (childNode.getNodeType() == Node.ELEMENT_NODE && "item".equals(childNode.getNodeName())) {
						String key = ((Element)childNode).getAttribute("key");
						String comment = ((Element)childNode).getAttribute("comment");
						String value = childNode.getTextContent();
						optionVOs.add(new OptionVO(key, value, comment));
					}
				}
				map.put(id, optionVOs);
				optionVOs = null;
			}
		} catch (ParserConfigurationException e) {
			log.error("解析配置文件错误", e);
		} catch (SAXException e) {
			log.error("解析配置文件错误", e);
		} catch (IOException e) {
			log.error("解析配置文件错误", e);
		}
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		return map;
	}
	
	public static void main(String[] args) {
		System.out.println(ConfigUtil.getConfigUtil().findById("1"));
	}
}
