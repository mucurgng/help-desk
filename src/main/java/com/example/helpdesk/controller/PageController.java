package com.example.helpdesk.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Help Desk");
        model.addAttribute("welcomeMessage", "Добро пожаловать в Help Desk");
        model.addAttribute("features", List.of(
                "Регистрация обращений",
                "Приоритизация задач",
                "Контакты поддержки"));
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "О нас");
        model.addAttribute("teamName", "Учебная команда Help Desk");
        model.addAttribute("description",
                "Мы создаём учебную систему для обработки обращений пользователей.");
        return "about";
    }

    @GetMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("pageTitle", "Контакты поддержки");
        model.addAttribute("supportEmail", "support@helpdesk.local");
        model.addAttribute("workTime", "Пн-Пт, 09:00-18:00");
        model.addAttribute("phone", "+7 (000) 000-00-00");
        model.addAttribute("requestChecklist", List.of(
                "Кратко опишите проблему",
                "Укажите, когда появилась ошибка",
                "Добавьте скриншот или текст сообщения об ошибке",
                "Напишите контакт для обратной связи"));
        return "contacts";
    }

    @GetMapping("/faq")
    public String faq(Model model) {
        model.addAttribute("pageTitle", "FAQ");
        model.addAttribute("questions", List.of(
                new FaqItem("Как создать обращение?",
                        "В следующих модулях на странице контактов появится форма создания обращения."),
                new FaqItem("Когда отвечает поддержка?",
                        "Учебная поддержка работает по будням с 09:00 до 18:00."),
                new FaqItem("Что делать, если проблема срочная?",
                        "Подготовьте описание, скриншот ошибки и контактные данные, чтобы команда быстрее разобралась.")));
        return "faq";
    }

    public record FaqItem(String question, String answer) {
    }
}
