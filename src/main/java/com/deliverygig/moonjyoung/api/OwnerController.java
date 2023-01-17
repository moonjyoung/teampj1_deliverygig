package com.deliverygig.moonjyoung.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliverygig.moonjyoung.entity.account.OwnerEntity;
import com.deliverygig.moonjyoung.service.OwnerInfoService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired OwnerInfoService oService;

    @PutMapping("/join")
    public ResponseEntity<Object> ownerJoin(@RequestBody OwnerEntity data) {
        Map<String, Object> resultMap = oService.addOwner(data);
        return new ResponseEntity<Object>(resultMap, (HttpStatus) resultMap.get("code"));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> ownerLogin(@RequestBody OwnerEntity data, HttpSession session) {
        Map<String, Object> resultMap = oService.loginOwner(data, session);
        return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
    }

//  @GetMapping ("/logout")  
//  public ResponseEntity<Object> ownerLogout(@RequestBody OwnerLoginVO data, HttpSession session) {
//    Map<String, Object> resultMap = oService.logoutOwner(data);
//    session.setAttribute("loginOwner", null);
//    return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
//  }


    //OwnerEntity loginOwner = (OwnerEntity)session.getAttribute("loginOwner");
    @PatchMapping("/update/{type}")
    public ResponseEntity<Object> ownerupdate(HttpSession session, @PathVariable String type, @RequestParam String value) {
        if(type.equals("oiPwd")) {
            Map<String, Object> resultMap = oService.updatePwd(value, type, session);
            return new ResponseEntity<>(resultMap, (HttpStatus) resultMap.get("code"));
        }
        else if(type.equals("oiNickName")) {
            Map<String, Object> resultMap = oService.updateNickname(value, type, session);
            return new ResponseEntity<>(resultMap, (HttpStatus) resultMap.get("code"));
        }
        else if(type.equals("oiEmail")) {
            Map<String, Object> resultMap = oService.updateEmail(value, type, session);
            return new ResponseEntity<>(resultMap, (HttpStatus) resultMap.get("code"));
        }
        else if(type.equals("oiPhone")) {
            Map<String, Object> resultMap = oService.updatePhone(value, type, session);
            return new ResponseEntity<>(resultMap, (HttpStatus) resultMap.get("code"));
        }
        else {
            Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
            resultMap.put("status", false);
            resultMap.put("message", "입력 오류");
            return new ResponseEntity<>(resultMap, HttpStatus.BAD_REQUEST);
        }
    }
  
    @DeleteMapping("/delete")
    public ResponseEntity<Object> ownerdelete(HttpSession session) {
        Map<String, Object> resultMap = oService.deleteOwner(session);
        return new ResponseEntity<>(resultMap, HttpStatus.ACCEPTED);
    }

    @PostMapping("/logout")  // 로그아웃 띄우기
    public ResponseEntity<Object> ownerLogout(HttpSession session) {
        Map<String, Object> resultMap = oService.logoutOwner(session);
        return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
    }

  // @PostMapping("/sujeong")
  // public ResponseEntity<Object> ownerSujeong(@RequestBody OwnerSujeongVO data, HttpSession session) {
  // Map<String, Object> resultMap = oService.SujeongOwner(data);
  //   return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
  // }

  // @DeleteMapping("/taltoe")
  // public ResponseEntity<Object> ownerTaltoe (@RequestBody , HttpSession session) {
  //   Map<String,Object> resultMap = oService.Tal
  // }
}