package service.theme;

import dao.themeDao;
import dao.themeDaoImpl;
import entity.Theme;

public class themeServiceImpl implements themeService {

	@Override
	public void addTheme(Theme theme) {
		//创建数据访问层对象
		themeDao themeDaoObject = new themeDaoImpl();
		
		//执行添加主题方法
		themeDaoObject.addTheme(theme);
	}
	
	@Override
	public boolean checkThemeIfExist(String themeName) {
		//创建数据访问层对象
		themeDao themeDaoObject = new themeDaoImpl();
		
		//用于存放判断结果
		boolean themeIfExist = false;
		
		//执行查询主题方法
		themeIfExist = themeDaoObject.checkThemeIfExist(themeName);
		return themeIfExist;
	}

}
