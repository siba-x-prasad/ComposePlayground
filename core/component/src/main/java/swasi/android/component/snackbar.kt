package swasi.android.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import swasi.android.component.internet.NetworkState
import swasi.android.component.theme.dp_0
import swasi.android.component.theme.dp_10
import swasi.android.component.theme.dp_24

@Composable
fun ShowSnackbar(isOffline: Boolean, contentMessage: String, snackbarHostState: SnackbarHostState) {

    LaunchedEffect(isOffline) {
        if (isOffline) {
            snackbarHostState.showSnackbar(
                message = contentMessage,
                duration = androidx.compose.material3.SnackbarDuration.Indefinite,
            )
        }
    }
}

@Composable
fun SnackbarShow(
    snackbarHostState: SnackbarHostState,
    networkState: MutableState<NetworkState>
) {
    if (snackbarHostState.currentSnackbarData == null) {
        when (networkState.value) {
            NetworkState.Connected -> {}
            NetworkState.Disconnected -> {
                Snackbar(
                    modifier = Modifier.padding(dp_10, dp_0, dp_10, dp_24)
                ) { Text(text = stringResource(R.string.no_internet)) }
            }
        }
    } else {
        SnackbarHost(snackbarHostState)
    }
}


