package service.theme;

import dao.themeDao;
import dao.themeDaoImpl;
import entity.Theme;

import java.util.List;

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



    @Override
    public List<Theme> findAllThemes() {

        //创建数据访问层对象
        themeDao themeDaoObject = new themeDaoImpl();

        return themeDaoObject.findAllThemes();
    }

    @Override
    public int updateTheme(Theme theme) {
        //创建数据访问层对象
        themeDao themeDaoObject = new themeDaoImpl();

        return themeDaoObject.updateTheme(theme);
    }

    @Override
    public Theme findThemeByName(String name) {
        //创建数据访问层对象
        themeDao themeDaoObject = new themeDaoImpl();
        return themeDaoObject.findThemeByName(name);
    }

    @Override
    public int deleteTheme(int tid) {
        //创建数据访问层对象
        themeDao themeDaoObject = new themeDaoImpl();
        return themeDaoObject.deleteTheme(tid);
    }

}
