import pytest
import time
from appium import webdriver


# NTS: Continue reading from: https://github.com/appium/sample-code/blob/master/sample-code/examples/python/android_simple.py
@pytest.fixture()
def driver():
    caps = {
        'platformName': 'Android',
        'deviceName': 'Android device',
        'appPackage': 'com.lexa.fakegps',
        'appActivity': 'com.lexa.fakegps.ui.Main',
        'app': '/Users/gaurav/mobile_apps/Android/fake_gps.apk',
        'newCommandTimeOut': '2400000'
    }

    driver = webdriver.Remote('http://localhost:4723/wd/hub', caps)
    yield driver
    driver.quit()


def test_appium_functionalities(driver):
    driver.find_element_by_xpath('//*[@content-desc="Open navigation drawer"]').click()
    driver.find_element_by_xpath('//*[@text="Go to"]').click()
    location = driver.find_element_by_xpath('//*[@text="latitude, longitude"]')

    # location.click()
    # driver.press_keycode(7)

    location.send_keys('1234,4566')
    time.sleep(10)
