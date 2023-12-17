package swasi.android.ui.views.internet

sealed class NetworkState {
    object Connected : NetworkState()
    object Disconnected : NetworkState()
}
