package dev.be.module_api.service;

import dev.be.module_api.exception.CustomException;
import dev.be.module_common.domain.Member;
import dev.be.module_common.enums.CodeEnum;
import dev.be.module_common.repository.MemberRepository;
import dev.be.module_common.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DemoService {

    private final CommonDemoService commonDemoService;
    private final MemberRepository memberRepository;

    @Value("${profile-name}") private String profileName;

    public String save() {
        System.out.println("profileName = " + profileName);

        memberRepository.save(Member.builder()
                .name(Thread.currentThread().getName())
                .build());
        return "save";
    }

    public String find() {
        int size = memberRepository.findAll().size();
        System.out.println("DB size : " + size);
        return "find";
    }

    public String exception() {
        if (true) {
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);
        }
        return "exception";
    }

}
