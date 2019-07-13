package dao;

import entity.Theme;

public interface themeDao {
	public void addTheme(Theme theme);
	public boolean checkThemeIfExist(String themeName);
}
