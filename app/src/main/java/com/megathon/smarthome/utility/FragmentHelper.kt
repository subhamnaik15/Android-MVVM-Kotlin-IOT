package test.cyron.nmschool.nmschool.utility

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager


object FragmentHelper {


    fun replaceFragment(activity: FragmentActivity, id: Int, fragment: Fragment) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(id, fragment)
        transaction.commitAllowingStateLoss()
    }

    fun replaceFragment(activity: FragmentActivity, id: Int, fragment: Fragment, backStack: Boolean) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(id, fragment)
        if (backStack)
            transaction.addToBackStack(fragment.javaClass.name)
        transaction.commitAllowingStateLoss()
    }

    fun replaceFragment(
        activity: FragmentActivity,
        container: Int,
        fragment: Fragment,
        backStack: Boolean,
        tag: String
    ) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(container, fragment, tag)
        if (backStack) transaction.addToBackStack(tag)
        transaction.commitAllowingStateLoss()
    }

    /**
     * @param activity   [FragmentActivity]
     * @param container
     * @param fragment   [Fragment]
     * @param backStack, true if [Fragment] needs to be added to back stack.
     */
    fun addFragment(
        activity: FragmentActivity, container: Int, fragment: Fragment,
        backStack: Boolean, isTransAllow: Boolean
    ) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        /*if (isTransAllow) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                transaction.addSharedElement(view, ViewCompat.getTransitionName(view))
            }
        }*/

        transaction.add(container, fragment)
        if (backStack) transaction.addToBackStack(fragment.javaClass.name)
        transaction.commitAllowingStateLoss()
    }

    /**
     * @param activity
     * @param container
     * @param fragment
     * @param backStack
     * @param tag
     */
    fun addFragment(activity: FragmentActivity, container: Int, fragment: Fragment, backStack: Boolean, tag: String) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.add(container, fragment, tag)
        if (backStack) transaction.addToBackStack(tag)
        transaction.commitAllowingStateLoss()
    }

    fun clearBackStack(activity: FragmentActivity) {
        try {
            activity.supportFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }

    }

    fun getRecentFragment(activity: FragmentActivity): Fragment? {
        val stackCount = activity.supportFragmentManager.backStackEntryCount
        val fragment: Fragment?
        if (stackCount <= 0)
            return null
        fragment =
            activity.supportFragmentManager.getBackStackEntryAt(stackCount - 1).name?.let { getFragment(activity, it) } as Fragment

        return fragment
    }

    fun getStackCount(activity: FragmentActivity): Int {
        val fragmentManager = activity.supportFragmentManager
        return fragmentManager.backStackEntryCount
    }

    fun getFragment(activity: FragmentActivity, containerId: Int): Fragment? {
        val fragmentManager = activity.supportFragmentManager
        return fragmentManager.findFragmentById(containerId)
    }

    fun getFragment(activity: FragmentActivity, TAG: String): Fragment? {
        val fragmentManager = activity.supportFragmentManager
        return fragmentManager.findFragmentByTag(TAG)
    }

}
