package com.cmc.kickstart.api.account.controller.v1.api;

import com.cmc.kickstart.api.account.controller.v1.request.AccountFindRequest;
import com.cmc.kickstart.core.tdo.util.BindingResultMapper;
import com.cmc.kickstart.api.account.dto.model.AccountDto;
import com.cmc.kickstart.api.account.service.AccountService;
import com.cmc.kickstart.core.tdo.response.PagingResponse;
import com.cmc.kickstart.core.tdo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Response<AccountDto>> get(@PathVariable Long id) {
        AccountDto account = accountService.findById(id);
        if (account != null) {
            return ResponseEntity.ok().body(Response.ok(account));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/find")
    public ResponseEntity<PagingResponse<AccountDto>> search(
        @Validated @RequestBody AccountFindRequest findRequest,
        BindingResult bindingResult
    ) {
        PagingResponse<AccountDto> response;

        if (bindingResult.hasErrors()) {
            response = PagingResponse.error("Invalid data.");
            return ResponseEntity.badRequest().body(response.setErrors(BindingResultMapper.toErrors(bindingResult)));
        }

        List<AccountDto> items = accountService.search(findRequest.getActive(), findRequest.getPage(),
            findRequest.getCount(), findRequest.getSorting());
        Long total = accountService.searchCount(findRequest.getActive());

        response = PagingResponse.ok(items)
            .setCount(items.size())
            .setPage(findRequest.getPage())
            .setTotal(total);

        return ResponseEntity.ok().body(response);
    }
}
