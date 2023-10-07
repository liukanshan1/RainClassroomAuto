import win32clipboard
from selenium import webdriver

if __name__ == '__main__':
    chrome_options = webdriver.ChromeOptions()
    chrome_options.add_extension(r'./tampermonkey.crx')
    driver = webdriver.Chrome(chrome_options)

    script = open(r'./monkeyScript.txt', 'r', encoding='utf-8').read()
    win32clipboard.OpenClipboard()
    win32clipboard.EmptyClipboard()
    win32clipboard.SetClipboardData(win32clipboard.CF_UNICODETEXT, script)
    win32clipboard.CloseClipboard()

