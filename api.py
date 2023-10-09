import uuid
from fastapi import FastAPI
import main
from fastapi.responses import HTMLResponse

app = FastAPI()
browsers = {}


@app.get("/")
def read_root():
    return {"Hello": "World"}


@app.get("/new")
def new_browser():
    browser = main.getBrowser('./script.txt')
    uid = uuid.uuid4()
    browsers[uid] = browser
    url = main.get_login(browser)
    return {"id": uid, "url": url}


@app.get("/login/{id}")
def login(uid: uuid.UUID):
    browser = browsers[uid]
    token = main.get_token(browser)
    browser.quit()
    return {"id": uid, "token": token}


@app.get("/start/{token}/{class_name}")
def start(token: str, class_name: str):
    browser = main.getBrowser('./script.txt')
    main.load_cookies(browser, token)
    main.start_auto(browser, class_name)
    input('输入任意键退出')
