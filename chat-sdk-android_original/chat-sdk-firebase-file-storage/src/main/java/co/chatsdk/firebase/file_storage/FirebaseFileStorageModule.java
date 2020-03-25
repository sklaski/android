package co.chatsdk.fireebase

import co.chatsdk.core.session.ChatSDK;
import co.chatsdk.firebase.file_storage.FirebaseUploadHandler;

File Storage(free)
        Firebase Push Notifications(free)
        Firebase Social Login(free)
        Fireabse UI(free)base.file_storage;

/**
 * Created by ben on 9/1/17.
 */

public class FirebaseFileStorageModule {

    public static void activate () {
        ChatSDK.a().upload = new FirebaseUploadHandler();
    }

}
