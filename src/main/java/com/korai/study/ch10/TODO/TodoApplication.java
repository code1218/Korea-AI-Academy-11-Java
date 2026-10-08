package com.korai.study.ch10.TODO;

import com.korai.study.ch10.TODO.router.RootRouter;


public class TodoApplication {
    public static void main(String[] args) {
        RootRouter.setUp();

        while(true) {
            RootRouter.getCurrentView().show();
        }
    }
}
