//package com.example.vhh.ui.di
//
//
//import androidx.room.Room
//import com.example.vhh.ui.auth.AuthViewModel
//import com.example.vhh.ui.data.db.DB
//import com.example.vhh.ui.data.respositories.ListingRepository
//import com.example.vhh.ui.data.respositories.UserRepository
//import com.example.vhh.ui.datastore.Settings
//import com.example.vhh.ui.socket.SocketClient
//import org.koin.android.ext.koin.androidApplication
//import org.koin.androidx.viewmodel.dsl.viewModel
//import org.koin.dsl.module
//
//val appModule = module {
//
//    single {
//        Settings(androidApplication())
//    }
//
//    single {
//        SocketClient()
//    }
//
//    //inject SplashViewModel
//    viewModel {
//        SplashViewModel(get())
//    }
//
//    //inject AuthViewModel
//    viewModel {
//        AuthViewModel(get())
//    }
//
//    //inject ExploreViewModal
//    viewModel {
//        ExploreViewModal()
//    }
//
//    //inject shopViewModel
//    viewModel {
//        ShopViewModel()
//    }
//
//    //inject NotificationViewModel
//    viewModel {
//        NotificationViewModel(get())
//    }
//
//    //inject SettingsViewModel
//    viewModel {
//        SettingsViewModel(get())
//    }
//
//    //inject ProfileViewModel
//    viewModel {
//        ProfileViewModel()
//    }
//
//    //inject ChatViewModel
//    viewModel {
//        ChatViewModel()
//    }
//
//    //inject OrderViewModel
//    viewModel {
//        OrderViewModel()
//    }
//
////    //inject WalletViewModel
////    viewModel {
////        WalletViewModel()
////    }
//
//    //inject JobViewModel
//    viewModel {
//        JobsViewModel()
//    }
//    // Database
//    single {
//
//        Room.databaseBuilder(
//            androidApplication(),
//            DB::class.java,
//            "cakkie.db",
//        )
//            .fallbackToDestructiveMigration()
////            .openHelperFactory(get()) //TODO: enable this when we're going live
//            .build()
//    }
//
//    // DAOs
//    single { get<DB>().userDao() }
//    single { get<DB>().listingDao() }
//
//    // Repositories
//    single { UserRepository(get()) }
//    single { ListingRepository(get()) }
//
//
//}
