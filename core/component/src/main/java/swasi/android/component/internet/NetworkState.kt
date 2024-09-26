package swasi.android.component.internet

sealed class NetworkState {
    object Connected : NetworkState()
    object Disconnected : NetworkState()
}
