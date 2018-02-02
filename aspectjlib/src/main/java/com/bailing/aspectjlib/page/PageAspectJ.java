package com.bailing.aspectjlib.page;

import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Desc:
 * Creator ling
 * Date:   2017/11/27 0027 16:50
 */
@Aspect
public class PageAspectJ {
    static final String TAG = "PageAspectJ";
    private static final String ACTIVITY_RESUME = "execution(* android.app.Activity.onResume(..))";
    private static final String ACTIVITY_PAUSE = "execution(* android.app.Activity.onPause(..))";

    private static final String FRAGMENT_RESUME =
        "execution(* android.app.Fragment.onResume(..)) || execution(* android.support.v4.app.Fragment.onResume(..))";
    private static final String FRAGMENT_PAUSE =
        "execution(* android.app.Fragment.onPause(..)) || execution(* android.support.v4.app.Fragment.onPause(..))";
    private static final String FRAGMENT_ONHIDDENCHANGED =
        "execution(* android.app.Fragment.onHiddenChanged(..)) || execution(* android.support.v4.app.Fragment.onHiddenChanged(..))";
    private static final String FRAGMENT_SETUSERVISIBLEHINT =
        "execution(* android.app.Fragment.setUserVisibleHint(..)) || execution(* android.support.v4.app.Fragment.setUserVisibleHint(..))";

    private static final String POINTCUT_TYPE =
        "!execution(@com.bailing.aspectjlib.page.DontAnalyticTrace * *(..))";

    @Pointcut(ACTIVITY_RESUME + "&&" + POINTCUT_TYPE)
    public void onActivityResume() {
    }

    @Pointcut(ACTIVITY_PAUSE + "&&" + POINTCUT_TYPE)
    public void onActivityPause() {
    }

    @Pointcut((FRAGMENT_RESUME) + "&&" + POINTCUT_TYPE)
    public void onFragmentResume() {
    }

    @Pointcut((FRAGMENT_PAUSE) + "&&" + POINTCUT_TYPE)
    public void onFragmentPause() {
    }

    @Pointcut((FRAGMENT_ONHIDDENCHANGED) + "&&" + POINTCUT_TYPE)
    public void onFragmentHiddenChanged() {
    }

    @Pointcut((FRAGMENT_SETUSERVISIBLEHINT) + "&&" + POINTCUT_TYPE)
    public void setUserVisibleHint() {
    }

    @Around("onActivityResume()")
    public void onActivityResume(ProceedingJoinPoint joinPoint) throws Throwable {
        // String key = joinPoint.getSignature().toString();
        DontAnalyticTrace analyticTrace =
            joinPoint.getTarget().getClass().getAnnotation(DontAnalyticTrace.class);
        if (analyticTrace == null) {
            String key = joinPoint.getThis().getClass().getSimpleName();
            Log.e(TAG, key + "==>>onResume: ");
        }
        joinPoint.proceed();
    }

    @Around("onActivityPause()")
    public void onActivityPause(ProceedingJoinPoint joinPoint) throws Throwable {
        DontAnalyticTrace analyticTrace =
            joinPoint.getTarget().getClass().getAnnotation(DontAnalyticTrace.class);
        if (analyticTrace == null) {
            String key = joinPoint.getThis().getClass().getSimpleName();
            Log.e(TAG, key + "==>>onPause: ");
        }
        joinPoint.proceed();
    }

    @Around("onFragmentResume()")
    public void onFragmentResume(ProceedingJoinPoint joinPoint) throws Throwable {
        DontAnalyticTrace analyticTrace =
            joinPoint.getTarget().getClass().getAnnotation(DontAnalyticTrace.class);
        if (analyticTrace == null) {
            Object object = joinPoint.getTarget();
            String pageName = object.getClass().getSimpleName();
            if (object instanceof Fragment) {
                Fragment fragment = (Fragment) object;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                    if (!fragment.isHidden() && fragment.getUserVisibleHint()) {
                        // TODO
                    }
                } else {
                    if (fragment.isVisible()) {
                        // TODO
                    }
                }
            } else if (object instanceof android.support.v4.app.Fragment) {
                android.support.v4.app.Fragment fragment = (android.support.v4.app.Fragment) object;
                Log.e(TAG, pageName + "==isHidden()==" + fragment.isHidden());
                Log.e(TAG, pageName + "==getUserVisibleHint==" + fragment.getUserVisibleHint());
                if (!fragment.isHidden() && fragment.getUserVisibleHint()) {
                    // TODO
                    Log.e(TAG, pageName + "==onFragmentResume");
                }
            }
        }

        joinPoint.proceed();
    }

    @Around("onFragmentPause()")
    public void onFragmentPause(ProceedingJoinPoint joinPoint) throws Throwable {
        DontAnalyticTrace analyticTrace =
            joinPoint.getTarget().getClass().getAnnotation(DontAnalyticTrace.class);
        if (analyticTrace == null) {
            Object object = joinPoint.getTarget();
            String pageName = object.getClass().getSimpleName();
            if (object instanceof Fragment) {
                Fragment fragment = (Fragment) object;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                    if (!fragment.isHidden() && fragment.getUserVisibleHint()) {
                        // TODO
                    }
                } else {
                    if (fragment.isVisible()) {
                        // TODO
                    }
                }
            } else if (object instanceof android.support.v4.app.Fragment) {
                android.support.v4.app.Fragment fragment = (android.support.v4.app.Fragment) object;
                Log.e(TAG, pageName + "==isHidden()==" + fragment.isHidden());
                Log.e(TAG, pageName + "==getUserVisibleHint()==" + fragment.getUserVisibleHint());
                if (!fragment.isHidden() && fragment.getUserVisibleHint()) {
                    // TODO
                    Log.e(TAG, pageName + "==onFragmentPause");
                }
            }
        }
        joinPoint.proceed();
    }

    @Around("onFragmentHiddenChanged()")
    public void onFragmentHiddenChanged(ProceedingJoinPoint joinPoint) throws Throwable {
        DontAnalyticTrace analyticTrace =
            joinPoint.getTarget().getClass().getAnnotation(DontAnalyticTrace.class);
        if (analyticTrace == null) {
            Object object = joinPoint.getTarget();
            Object[] args = joinPoint.getArgs();
            boolean hidden = false;
            if (args != null && args.length > 0 && args[0] instanceof Boolean) {
                hidden = (Boolean) args[0];
            }
            String pageName = object.getClass().getSimpleName();
            if (object instanceof Fragment) {
                Fragment fragment = (Fragment) object;
                if (fragment.isResumed()) {
                    if (hidden) {
                        // TODO 隐藏
                    } else {
                        // TODO 显示
                    }
                }
            } else if (object instanceof android.support.v4.app.Fragment) {
                android.support.v4.app.Fragment fragment = (android.support.v4.app.Fragment) object;
                if (fragment.isResumed()) {
                    Log.e(TAG, pageName + "==hidden==" + hidden);
                    if (hidden) {
                        // TODO  隐藏
                    } else {
                        // TODO  显示
                    }
                }
            }
        }
        joinPoint.proceed();
    }

    @Around("setUserVisibleHint()")
    public void setUserVisibleHint(ProceedingJoinPoint joinPoint) throws Throwable {
        DontAnalyticTrace analyticTrace =
            joinPoint.getTarget().getClass().getAnnotation(DontAnalyticTrace.class);
        if (analyticTrace == null) {
            Object object = joinPoint.getTarget();
            Object[] args = joinPoint.getArgs();
            boolean isVisibleToUser = false;
            if (args != null && args.length > 0 && args[0] instanceof Boolean) {
                isVisibleToUser = (Boolean) args[0];
            }

            String pageName = object.getClass().getSimpleName();

            if (object instanceof Fragment) {
                Fragment fragment = (Fragment) object;
                if (fragment.isResumed()) {
                    if (isVisibleToUser) {
                        // TODO
                    } else {
                        // TODO
                    }
                }
            } else if (object instanceof android.support.v4.app.Fragment) {
                android.support.v4.app.Fragment fragment = (android.support.v4.app.Fragment) object;
                if (fragment.isResumed()) {
                    Log.e(TAG, pageName + "==isVisibleToUser==" + isVisibleToUser);
                    if (isVisibleToUser) {
                        // TODO
                    } else {
                        // TODO
                    }
                }
            }
        }
        joinPoint.proceed();
    }
}
