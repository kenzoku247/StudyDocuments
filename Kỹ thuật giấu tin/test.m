% Watermarking parameters
a = 1;    % scaling factor for watermark signal
b = 0.5;  % randomization factor for watermark signal
c = 0.01; % scaling factor for host signal
fe = 2;   % exponent for the exponential function

% Load the image and convert to grayscale
img = imread('image.png');
img = rgb2gray(img);

% Apply wavelet transform and select low-frequency subband
[cA, cH, cV, cD] = dwt2(img, 'haar');
LL1 = cA;

% Generate binary watermark signal
watermark = randi([0,1], size(LL1));

% Apply transfer function to watermark signal
TF_watermark = a * (b + c * watermark) .* exp(-(c * watermark).^fe);

% Embed the transformed watermark into the host signal
watermarked_LL1 = LL1 + TF_watermark;

% Reconstruct the watermarked image
watermarked_img = idwt2(watermarked_LL1, cH, cV, cD, 'haar');

% Extract the watermark from the watermarked image
extracted_watermark = (watermarked_LL1 - LL1) ./ (a * c * exp(-(c * LL1).^fe));

% Verify that the extracted watermark matches the original watermark
isequal(watermark, extracted_watermark)