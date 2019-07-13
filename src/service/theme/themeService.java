package service.theme;

import entity.Theme;

public interface themeService {
	public void addTheme(Theme theme);
	public boolean checkThemeIfExist(String themeName);
}
