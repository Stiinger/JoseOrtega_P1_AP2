package edu.ucne.joseortega_p1_ap2.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import edu.ucne.joseortega_p1_ap2.presentation.sistema.SistemaListScreen
import edu.ucne.joseortega_p1_ap2.presentation.sistema.SistemaScreen

@Composable
fun ParcialNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.SistemaList
    ) {
        composable<Screen.SistemaList> {
            SistemaListScreen(
                createSistema = { navHostController.navigate(Screen.Sistema(0)) },
                goToSistema = { sistemaId->
                    navHostController.navigate(Screen.Sistema(sistemaId = sistemaId))
                }
            )
        }
        composable<Screen.Sistema> {
            val sistemaId = it.toRoute<Screen.Sistema>().sistemaId
            SistemaScreen(
                sistemaId = sistemaId,
                goBackToList = { navHostController.navigateUp() }
            )
        }
    }
}