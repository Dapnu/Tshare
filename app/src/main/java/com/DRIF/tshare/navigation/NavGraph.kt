import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.DRIF.tshare.navigation.Screens
import com.DRIF.tshare.presentation.login_screen.OneTapSignInViewModel
import com.DRIF.tshare.presentation.login_screen.SignInScreen
import com.DRIF.tshare.presentation.signup_screen.SignUpScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationGraph(
    navController: NavHostController,
    oneTapSignInViewModel: OneTapSignInViewModel
) {

    AnimatedNavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route
    ) {
        composable(route = Screens.FireSignInScreen.route) {
            SignInScreen(
                navController = navController,
                oneTapSignInViewModel = oneTapSignInViewModel
            )
        }
        composable(route = Screens.FireSignUpScreen.route) {
            SignUpScreen(navController = navController)
        }
    }

}