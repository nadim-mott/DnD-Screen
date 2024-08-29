package namfo.Entities;
import java.text.ParseException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Evaluator {

    public static int evaluate_nDm(int n, int m){
        int returnee = 0;
        Random rand = new Random();
        for(int i = 0; i < n; i++){
            returnee += rand.nextInt(m + 1);
        }
        return returnee;
        
    }
    
    public static int parse_expression(String expression, Creature creature) throws ParseException{
        Pattern variable_pattern = Pattern.compile("(.*)\\[(.*)](.*)");
        Matcher variable_matcher = variable_pattern.matcher(expression);
        if (variable_matcher.matches()){
            String pre_variable = variable_matcher.group(1);
            String variable = variable_matcher.group(2);
            String post_variable = variable_matcher.group(3);
            int variable_amount = creature.get_stat_by_name(variable).get_stat_amount();
            return parse_expression(pre_variable + Integer.toString(variable_amount) + post_variable, creature);
        }
        return parse_expression(expression);
    }

    public static int parse_expression(String expression) throws ParseException{
        // ---- Base Cases: ----
        if (expression.isEmpty()){
            // Base Case: empty string.
            throw new ParseException("Could not parse empty expression"+ expression, 0);
        }else if (expression.matches("^-?\\d+$")) {
            // Base Case: just digits.
            return Integer.valueOf(expression);
        }
        // ---- Recursive Cases: ----
        // Parenthesis:
        Pattern parenthesis_pattern = Pattern.compile("(.*)\\((.*)\\)(.*)");
        Matcher parenthesis_matcher = parenthesis_pattern.matcher(expression);
        if (parenthesis_matcher.matches()){
                String pre_parenthesis = parenthesis_matcher.group(1);
                String inner_parenthesis = parenthesis_matcher.group(2);
                String post_parenthesis = parenthesis_matcher.group(3);
                int value_of_inner = parse_expression(inner_parenthesis);
                if (pre_parenthesis.matches(".*\\d")){
                    pre_parenthesis.concat("*");
                }
                if (post_parenthesis.matches("\\d.*")){
                    post_parenthesis = "*" + post_parenthesis;
                }
                return parse_expression(pre_parenthesis + Integer.toString(value_of_inner) + post_parenthesis);
        } 
        // Subtraction:
        Pattern sub_pattern = Pattern.compile("(.*\\d)\\-(.*)");
        Matcher sub_matcher = sub_pattern.matcher(expression);
        if (sub_matcher.matches()){
            String pre_sub = sub_matcher.group(1);
            String post_sub = sub_matcher.group(2);
            return parse_expression(pre_sub + "+-" + post_sub);
        }

        // Addition:
        Pattern add_pattern = Pattern.compile("(.+)\\+([^+]+)");
        Matcher add_matcher = add_pattern.matcher(expression);
        if (add_matcher.matches()){
            String pre_add = add_matcher.group(1);
            String post_add = add_matcher.group(2);
            return parse_expression(Integer.toString(parse_expression(pre_add) + parse_expression(post_add)));
        }
        // Multiplication and division:
        Pattern multdiv_pattern = Pattern.compile("(.+)([*/])([^*/]+)");
        Matcher multdiv_matcher = multdiv_pattern.matcher(expression);
        if (multdiv_matcher.matches()){
            String pre_multdiv = multdiv_matcher.group(1);
            String multdiv = multdiv_matcher.group(2);
            String post_multdiv = multdiv_matcher.group(3);
            if (multdiv.equals("*")){
                return parse_expression(Integer.toString(parse_expression(pre_multdiv) * parse_expression(post_multdiv)));
            } else {
                return parse_expression(Integer.toString(parse_expression(pre_multdiv) / parse_expression(post_multdiv)));
            }
        }
        // Rolling dice:
        Pattern dice_pattern = Pattern.compile("(.+)[dD]([^dD]+)");
        Matcher dice_matcher = dice_pattern.matcher(expression);
        if (dice_matcher.matches()){
            String pre_dice = dice_matcher.group(1);
            String post_dice = dice_matcher.group(2);
            return parse_expression(Integer.toString(evaluate_nDm(parse_expression(pre_dice), parse_expression(post_dice))));
        }

        throw new ParseException("Could not parse expression "+ expression, 0);
    }
}
