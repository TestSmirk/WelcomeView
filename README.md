# WelcomeView
实现倒计时,不新建Activity  使用方法  
```
WelcomeUtil.open(this, welcomeImageUrl, new WelcomeUtil.OnWelcomeDone() {
            @Override
            public void onDone() {
                //需要把onCreate调用的方法都扔到这里.
                setContentView(R.layout.activity_main);
            }
        });
```
