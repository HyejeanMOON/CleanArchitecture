package com.hyejeanmoon.democleanarchitecture.dagger2

import com.hyejeanmoon.democleanarchitecture.fragments.TopFragment
import dagger.Component

/**
 * top画面用のcomponent
 */
@Component
interface TopFragmentComponent {

    fun inject(topFragment: TopFragment)


}