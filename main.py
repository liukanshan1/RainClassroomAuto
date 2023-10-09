import os
import pickle
import time

from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait


def getBrowser(script_path):
    chrome_options = webdriver.ChromeOptions()
    chrome_options.add_extension(r'./tampermonkey.crx')
    browser = webdriver.Chrome(chrome_options)
    # 导入脚本
    browser.get(r'chrome-extension://dhdgffkkebhmkfjojejmpbldmpobfkfo/options.html#nav=utils')
    wait = WebDriverWait(browser, 10)
    element = wait.until(EC.presence_of_element_located((By.XPATH, '//*[@id="input_ZmlsZV91dGlscw_file"]')))
    element.send_keys(os.path.abspath(script_path))
    while len(browser.window_handles) != 3:
        pass
    browser.switch_to.window(browser.window_handles[1])
    imp = browser.find_element(by=By.XPATH, value='//*[@id="input_GVfdW5kZWZpbmVk_bu"]')
    imp.click()
    browser.switch_to.window(browser.window_handles[0])
    return browser


def save_cookies(browser):
    browser.get(r'https://changjiang.yuketang.cn/web?next=/v2/web/index&type=3')
    el = browser.find_element(By.XPATH, '//*[@id="support-socket"]/div/img[2]')  # 找到元素
    img_url = el.get_attribute('src')
    print("获取登录二维码")
    print(img_url)
    wait = WebDriverWait(browser, 100)
    wait.until(EC.url_contains('https://changjiang.yuketang.cn/v2/web/index?date'))
    cookies = browser.get_cookies()
    path = './' + cookies[0].get('value') + '.pkl'
    pickle.dump(cookies, open(path, 'wb'))
    return cookies[0].get('value')


def get_login(browser):
    browser.get(r'https://changjiang.yuketang.cn/web?next=/v2/web/index&type=3')
    el = browser.find_element(By.XPATH, '//*[@id="support-socket"]/div/img[2]')  # 找到元素
    img_url = el.get_attribute('src')
    return img_url


def get_token(browser):
    wait = WebDriverWait(browser, 100)
    wait.until(EC.url_contains('https://changjiang.yuketang.cn/v2/web/index?date'))
    cookies = browser.get_cookies()
    path = './' + cookies[0].get('value') + '.pkl'
    pickle.dump(cookies, open(path, 'wb'))
    return cookies[0].get('value')


def load_cookies(browser, id):
    browser.get(r'https://changjiang.yuketang.cn/web?next=/v2/web/index&type=3')
    cookies = pickle.load(open('./' + id + '.pkl', 'rb'))
    for cookie in cookies:
        browser.add_cookie(cookie)
    browser.get(r'https://changjiang.yuketang.cn/web?next=/v2/web/index&type=3')
    wait = WebDriverWait(browser, 10)
    wait.until(EC.url_contains('https://changjiang.yuketang.cn/v2/web/index?date'))


def start_auto(browser, class_name):
    el = browser.find_element(By.XPATH, '//*[@id="tab-student"]')  # 找到元素
    ActionChains(browser).move_to_element(el).click().perform()
    wait = WebDriverWait(browser, 10)
    wait.until(EC.presence_of_all_elements_located((By.XPATH, '//*[@class="className"]')))
    # 获取当前页面的高度
    last_height = browser.execute_script("return document.body.scrollHeight")
    # 模拟下拉操作，直到滑动到底部
    while True:
        # 模拟下拉操作
        browser.execute_script("window.scrollTo(0, document.body.scrollHeight);")
        # 等待页面加载
        time.sleep(1)
        # 获取当前页面的高度
        new_height = browser.execute_script("return document.body.scrollHeight")
        # 判断是否已经到达页面底部
        if new_height == last_height:
            break
        # 继续下拉操作
        last_height = new_height
    els = browser.find_elements(By.CLASS_NAME, 'className')
    for i in els:
        if i.text == class_name:
            ActionChains(browser).move_to_element(i).click().perform()
            break
    wait = WebDriverWait(browser, 10)
    wait.until(EC.url_contains('https://changjiang.yuketang.cn/v2/web/studentLog/'))
    # 点击刷课
    el = browser.find_element(By.XPATH, '//*[@id="n_clear"]')
    el.click()
    el = browser.find_element(By.XPATH, '//*[@id="n_button"]')
    el.click()


if __name__ == '__main__':
    browsers = []
    while True:
        cn = input("请输入课程名, 输入1默认形势与政策:  ")
        if cn == "1":
            cn = '2023秋-形势与政策课'
        # 登录
        browser = getBrowser('./script.txt')
        uid = save_cookies(browser)
        # browser.quit()
        # 刷课
        # browser = getBrowser('./script.txt')
        # load_cookies(browser, uid)
        start_auto(browser, cn)
        browsers.append(browser)
    # input('输入任意键退出')
