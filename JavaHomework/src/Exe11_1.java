
/**
 * @Author Gallon
 * @ClassName Exe10_1
 * @Description an answerer in stackoverflow:"You are entering a tricky area for the Swing library. However, nothing
 * is impossible. You can create such animation using Timer, but I really recommend you do not do it.
 * ......This was one reason that the JavaFX technology came into our hands."
 * 同时题目中没有强制要求使用swing，故尝试使用JavaFX完成这一题
 * @Time 2021-12-21,周二 17:03
 */
//本题参考 https://www.hameister.org/JavaFX_TimelineAnimation.html 修改部分代码，并添加了行注释翻译

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import static javafx.util.Duration.millis;

/**
 * @Author Gallon
 * @ClassName Exe11_1
 * @Description Application的子类，实现主要功能
 * @Time 2021-12-21,周二 18:45
 */
public class Exe11_1 extends Application {
    // Number of steps for a circle/ball during one orbit. 一个圆球在一个轨道上的步数。
    private static final int MOVING_POINTS = 60;
    // Ball speed 球速
    private static final int STEP_DURATION_IN_MILLISECONDS = 60;
    // Scene Size 场景大小
    private static final int SCENE_SIZE = 600;

    @Override
    public void start(Stage primaryStage) {
        // 界面的中心，类似参数方程的解法
        final int midPoint = SCENE_SIZE / 2;
        // Orbits of the balls (Radius) 球的轨道（半径）
        int ballOrbit = 100;
        // Size of the circles 圆圈的大小
        final int[] ballRadius = {20, 10};
        Circle ball = new Circle(50);
        //创建两个Circle实例
        List<Circle> balls = new ArrayList<>();
        for (int i = 0; i < ballRadius.length; i++) {
            balls.add(new Circle(ballRadius[i]));
        }
        balls.get(0).setFill(Color.BLUE);
        balls.get(1).setFill(Color.RED);
        final Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new EventHandler() //事件处理程序
                {
                    int movingStep = 0;

                    @Override
                    public void handle(Event event) {
                        movingStep++;
                        double angleAlpha = movingStep * (Math.PI / 30);
                        for (int i = 0; i < balls.size(); i++) {
                            // 类似圆参数方程的构建 x0，y0 代表原点所在坐标。
                            // p(x) = x(0) + r * sin(a)
                            // p(y) = y(0) - r * cos(a)
                            if (i == 1)
                                moveBall(balls.get(i)
                                        , midPoint + ballOrbit * Math.sin(angleAlpha)
                                        , midPoint - ballOrbit * Math.cos(angleAlpha));
                                // 类似椭圆参数方程的构建 x0，y0 代表原点所在坐标。
                                // p(x) = x(0) + 200 * sin(a)
                                // p(y) = y(0) - 100 * cos(a)
                                // 一加一减 => 顺时针效果
                            else moveBall(balls.get(i)
                                    , midPoint + 200 * Math.sin(angleAlpha)
                                    , midPoint - 100 * Math.cos(angleAlpha));
                        }
                        // Reset after one orbit. 一圈后重置。
                        if (movingStep == MOVING_POINTS) {
                            movingStep = 0;
                        }
                    }
                }), new KeyFrame(Duration.millis(STEP_DURATION_IN_MILLISECONDS)));

        timeline.setCycleCount(Timeline.INDEFINITE);

        Pane root = new Pane();
        root.getChildren().addAll(balls);

        Scene scene = new Scene(root, SCENE_SIZE, SCENE_SIZE);

        primaryStage.setTitle("Rotating Balls");
        primaryStage.setScene(scene);
        primaryStage.show();
        timeline.play();
    }

    private void moveBall(Circle ball, double x, double y) {
        TranslateTransition move = TranslateTransitionBuilder.create()
                .node(ball)
                .toX(x)
                .toY(y)
                .duration(millis(STEP_DURATION_IN_MILLISECONDS))
                .build();
        move.playFromStart();
    }

    public static void main(String[] args) {
        launch(args);
    }
}