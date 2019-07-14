package dao;

import entity.Theme;

import java.util.List;

public interface themeDao {
    public void addTheme(Theme theme);
    public boolean checkThemeIfExist(String themeName);

    public List<Theme> findAllThemes();
    // 更新主题
    public int updateTheme(Theme theme);
    // 根据名字查找主题
    public Theme findThemeByName(String name);
    // 通过tid删除主题
    public int deleteTheme(int tid);
}
