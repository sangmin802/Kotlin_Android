package com.example.camera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.FileProvider
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

// 카메라 기능 사용하기
class MainActivity : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1 // 카메라 사진촬영 요청코드
    lateinit var curPhotoPath : String // 그냥 미리 선언해놓는 문자열 형태의 사진 경로

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mainfests에 필요한 권한들을 요청한다
//          단, 안드로이드 공문에 기재된 몇몇의 권한들은 개인정보와 관련된 위험권한으로 사용자에게 허락을 받아야 한다.
//          허락 팝업을 위해 gradle에 추가를 한다.
//              implementation 'gun0912.ted:tedpermission:2.2.3'
        setPermission() // 권한 체크 메소드 수행

        btn_camera.setOnClickListener {
            takeCapture() // 사진 촬영
        }
    }

//    권한 요청 팝업 설정
    private fun setPermission() {
        val permission = object : PermissionListener {
            override fun onPermissionGranted() { // 설정해놓은 위험권한들이 모두 허용 되었을 경우 실행
                Toast.makeText(this@MainActivity, "권한이 허용 되었습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) { // 설정해놓은 위험권한들이 하나라도 거부되었을 경우 실행
                Toast.makeText(this@MainActivity, "권한이 거부 되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        TedPermission.with(this)
            .setPermissionListener(permission)
            .setRationaleMessage("카메라 앱을 사용하시려면 권한을 허용해주세요.")
            .setDeniedMessage("권한을 거부하셨습니다. [앱 실행] -> [권한] 항목에서 허용해주세요.")
            .setPermissions(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA)
            .check()
    }

//    사진 촬영
    private fun takeCapture() {
//    기본 카메라 앱 실행
//    카메라 기능도 Activity 형태이기 때문에, Intent로 화면전환을 사용한다.
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                val photoFile : File? = try {
                    createImageFile()
                } catch (ex : IOException) {
                    null
                }
                photoFile?.also {
                    val photoURI : Uri = FileProvider.getUriForFile(
                        this,
                        "com.example.camera.fileprovider",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
//                    startActivity만 있으면, 단순히 카메라 Activity로 이동만 하지만
//                    startActivityForResult를 쓰면, 갔다가 결과값을 받고 돌아온다
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

//    이미지 파일 생성
    private fun createImageFile(): File {
        val timestamp : String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir : File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_${timestamp}_", ".jpg", storageDir)
            .apply { curPhotoPath = absolutePath }
    }

//    startActivityForResult를 사용해서 받아온 사진 결과값.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//    이미지를 성공적으로 가져 왔다면
        if(requestCode === REQUEST_IMAGE_CAPTURE && resultCode === Activity.RESULT_OK) {
            val bitmap : Bitmap
            val file = File(curPhotoPath)
            if(Build.VERSION.SDK_INT < 28) { // 안드로이드 9.0버전보다 낮을경우
                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, Uri.fromFile(file))
                iv_profile.setImageBitmap(bitmap)
            }else{
                val decode = ImageDecoder.createSource(
                    this.contentResolver,
                    Uri.fromFile(file)
                )
                bitmap = ImageDecoder.decodeBitmap(decode)
                iv_profile.setImageBitmap(bitmap)
            }
            savePhoto(bitmap)
        }
    }

//    갤러리에 저장
    private fun savePhoto(bitmap: Bitmap) {
//    사진폴더에 저장하기 위한 경로
        val folderPath = Environment.getExternalStorageDirectory().absolutePath + "/Pictures/"
        val timestamp : String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val fileName = "${timestamp}.jpeg"
        val folder = File(folderPath)
        if(!folder.isDirectory) { // 해당 경로에 폴더가 존재하지 않는다면
            folder.mkdirs()
        }

//    저장저리
        val out = FileOutputStream(folderPath + fileName)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
        Toast.makeText(this, "사진이 저장되었습니다.", Toast.LENGTH_SHORT).show()
    }
}