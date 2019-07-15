package com.seven.service.theme;
import com.seven.entity.Theme;

import java.util.List;

public interface themeService {
    //添加
    public void addTheme(Theme theme);
    //检查是否存在
    public boolean checkThemeIfExist(String themeName);
    // 获取所有主题
    public List<Theme> findAllThemes();
    // 更新主题
    public int updateTheme(Theme theme);
    // 根据名字查找主题
    public Theme findThemeByName(String name);
    // 通过tid删除主题
    public int deleteTheme(int tid);

}
