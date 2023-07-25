% Watermarking parameters
a_constant = 1;    % scaling factor for watermark signal
b_constant = 0.5;  % randomization factor for watermark signal
c_constant = 0.1; % scaling factor for host signal
fe_constant = 2;   % exponent for the exponential function

% Load the image and convert to grayscale
img = imread('image1.jpeg');
img = im2gray(img);

[LL, LH, HL, HH] = dwt2(img,'haar');
[LL1,LH1,HL1,HH1] = dwt2(LL,'haar');

% Load the watermark image
w = imread('logo.png');
w_double = im2double(w);

H_TF = a_constant * (b_constant + c_constant * LL1) .* exp(-(c_constant).^fe_constant);
%figure;
%histogram(LL1);
%figure;
%histogram(H_TF);

BH = cell(size(H_TF,1)/8, size(H_TF,2)/8);
for i = 1:size(BH,1)
    for j = 1:size(BH,2)
        BH{i,j} = H_TF((i-1)*8+1:i*8, (j-1)*8+1:j*8);
    end
end


% Split w into sub-blocks of size 4x5 pixels
Bw = cell(size(w,1)/4, size(w,2)/5);
for i = 1:size(Bw,1)
    for j = 1:size(Bw,2)
        Bw{i,j} = w((i-1)*4+1:i*4, (j-1)*5+1:j*5);
    end
end


Bw_double = cell(size(w_double,1)/4, size(w_double,2)/5);
for i = 1:size(Bw_double,1)
    for j = 1:size(Bw_double,2)
        Bw_double{i,j} = w_double((i-1)*4+1:i*4, (j-1)*5+1:j*5);
    end
end

% Calculate the average of each sub-block of Bw
M = zeros(size(Bw));
for i = 1:size(Bw,1)
    for j = 1:size(Bw,2)
        M(i,j) = mean(Bw{i,j}(:));
    end
end

% Arrange the sub-block averages into a vector
M = round(reshape(M, [], 1));

% Convert the decimals numbers into binary numbers in the averages vector M
M_bin = string(dec2bin(M)) ;

% Select the bit 1 beside the MSB bit
bit1_idx = zeros(size(M));
for i = 1:numel(M)
    x = 7;
    for j = 1:(x)
        if bitget(M(i), x) == 1
            bit1_idx(i) = 8 - x;
        else
            x = x - 1;
        end
    end
end

k = sqrt(bit1_idx+reshape(1:252,[],1));



output_1 = BH;
output_2 = Bw_double;

for i = 1:size(Bw_double,2)*size(Bw_double,1)
    b = mod(i,16);
    a = fix(i/16) + 1;
    if b == 0
        b = 16;
        a = fix(i/16);
    end 
    output_1{a,b} = PixelMovement(output_1{a,b},1);
    
    d = mod(i,14);
    c = fix(i/14) + 1;
    if d == 0
        d = 14;
        c = fix(i/14);
    end 
    output_2{c,d} = immultiply(output_2{c,d},k(i,:));
    
end

output_3 = output_1;

for i = 1:size(Bw_double,2)*size(Bw_double,1)
    b = mod(i,16);
    a = fix(i/16) + 1;
    if b == 0
        b = 16;
        a = fix(i/16);
    end 
    d = mod(i,14);
    c = fix(i/14) + 1;
    if d == 0
        d = 14;
        c = fix(i/14);
    end 
    output_3{a,b}(1:4,1:5) = output_1{a,b}(1:4,1:5) + output_2{c,d};
end

for i = 1:size(Bw_double,2)*size(Bw_double,1)
    b = mod(i,16);
    a = fix(i/16) + 1;
    if b == 0
        b = 16;
        a = fix(i/16);
    end 
    output_3{a,b} = InversePixelMovement(output_3{a,b},1);
end

% Initialize the output matrix
H_TF_inverse = zeros(size(output_3,1)*8, size(output_3,2)*8);

% Fill in the output matrix with the contents of BH
for i = 1:size(output_3,1)
    for j = 1:size(output_3,2)
        H_TF_inverse((i-1)*8+1:i*8, (j-1)*8+1:j*8) = output_3{i,j};
    end
end

% Solve for LL1w
LL1w = (H_TF_inverse ./ (a_constant * exp(-(c_constant).^fe_constant)) - b_constant) / c_constant;

% LLw
LLw = idwt2(LL1w, LH1,HL1,HH1, 'haar');

% Img w
image_w = idwt2(LLw, LH, HL, HH, 'haar');

figure;
subplot(1,2,1);imshow(img,[]);title('img');
subplot(1,2,2);imshow(image_w,[]);title('image_w');

function PMFsubBH = PixelMovement(sub_BH,N)
    PMFsubBH = sub_BH;
    for i =1:N
        
        
        for j = 1:2:8
            shifted_column = sub_BH(:,j);
            end_vl = shifted_column(end);
            rest_vl = shifted_column(1:end-1);
            shifted_column(1) = end_vl;
            shifted_column(2:end) = rest_vl;
            
            PMFsubBH(:,j) = shifted_column;
        end
        
        for k = 1:2:8
            shifted_column = sub_BH(k,:);
            end_vl = shifted_column(end);
            rest_vl = shifted_column(1:end-1);
            shifted_column(1) = end_vl;
            shifted_column(2:end) = rest_vl;
            
            PMFsubBH(k,:) = shifted_column;
        end
         
    end
end

function PMFsubBH = InversePixelMovement(sub_BH,N)
    PMFsubBH = sub_BH;
    for i =1:N
        for j = 1:2:8
            shifted_column = sub_BH(:,j);
            first_vl = shifted_column(1);
            rest_vl = shifted_column(2:end);
            shifted_column(end) = first_vl;
            shifted_column(1:end-1) = rest_vl;
            
            PMFsubBH(:,j) = shifted_column;
        end
        
        for k = 1:2:8
            shifted_column = sub_BH(k,:);
            first_vl = shifted_column(1);
            rest_vl = shifted_column(2:end);
            shifted_column(end) = first_vl;
            shifted_column(1:end-1) = rest_vl;
            
            PMFsubBH(k,:) = shifted_column;
        end
         
    end
end

